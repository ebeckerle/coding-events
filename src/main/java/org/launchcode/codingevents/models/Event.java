package org.launchcode.codingevents.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message="Event Name is Required")
    @Size(min= 3, max = 50, message="Name must be between 3 and 50 characters")
    private String name;

    @Size(max=500, message="Description must be under 500 characters.")
    private String description;

    @NotBlank(message="Email Address is Required")
    @Email(message="Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message="A Location is Required")
    private String location;

    @Future(message="Cannot add an event that is already over. Please enter a future date.")
    private Date dates;

    @AssertTrue(message="sorry, for the purposes of this exercise, attendees must Register, so we can practice using more validation annotations")
    private Boolean registration;

    @Positive(message="Number of Attendees must be a positive number")
    private Integer attendees;

    private EventType type;



    public Event(String name, String description, String contactEmail, String location, Date dates, Boolean registration, Integer attendees, EventType type){
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.dates = dates;
        this.registration = registration;
        this.attendees = attendees;
        this.type = type;
    }

    public Event(){ }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Boolean getRegistration() {
        return registration;
    }

    public void setRegistration(Boolean registration) {
        this.registration = registration;
    }

    public Integer getAttendees() {
        return attendees;
    }

    public void setAttendees(Integer attendees) {
        this.attendees = attendees;
    }

    public EventType getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
