package edu.lawrence.events.controllers;

import edu.lawrence.events.objects.Event;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins="*")
public class EventController {
    private EventDAO dao;
    
    public EventController(EventDAO dao) {
        this.dao = dao;
    }
    
    @GetMapping("/{id}")
    public Event eventById(@PathVariable("id") int id) {
        return dao.findById(id);
    }
}
