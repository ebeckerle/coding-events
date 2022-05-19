package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExampleController {

    @GetMapping("example")
    public String getExamplePage(Model model){
        String paragraphString = "Boil em, mash em, stick em in a stew";
        model.addAttribute("templateText", paragraphString);

        List<String> shadesOfPink = new ArrayList<>();
        shadesOfPink.add("magenta");
        shadesOfPink.add("magenta");
        shadesOfPink.add("magenta");
        model.addAttribute("templateShadesOfPink", shadesOfPink);
        return "examples/example";

    }

}
