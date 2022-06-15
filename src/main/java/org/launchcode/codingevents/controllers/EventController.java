package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("title", "All Events");
        model.addAttribute("events",eventRepository.findAll());
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model){
        model.addAttribute("title","Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }


    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title","Create Event");
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:";
    }


    @GetMapping("delete")
    public String renderDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds){
        if (eventIds != null){
            for(int id : eventIds){
                eventRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

//    @GetMapping("edit/{eventId}")
//    public String displayEditEventForm(Model model, @PathVariable int eventId){
//
//        model.addAttribute("title", "Edit Event : "+EventData.getById(eventId).getName()+"(id="+eventId+")");
//        model.addAttribute("name", EventData.getById(eventId).getName());
//        model.addAttribute("description", EventData.getById(eventId).getDescription());
//        return "events/edit";
//    }
//
//    @PostMapping("edit")
//    public String processEditForm(int eventId, String name, String description){
//        Optional<Event> editedEvent = eventRepository.findById(eventId);
//        editedEvent.setName(name);
//        editedEvent.setDescription(description);
//        return "redirect:";
//    }
}
