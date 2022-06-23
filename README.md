# coding-events

Purpose
  To allow the user to create, categorize, and tag coding events.
  
 Current State
  Complete Models, Views, and Controllers to allow the user to create and delete categories, create and delete tags, create and delete events, 
  as well as categorize each event and add one or more tags to it.
  
 TODO - Future Improvements:
  Add in a user sign-up feature that allows site-visitors to create an account and sign-up for events.
    :: TODO: add a Person Class with the following fields & methods
    PERSON
      - username
      - pwhash
      - @OneToMany eventsAttending
      - email
