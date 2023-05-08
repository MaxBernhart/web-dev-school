package edu.lawrence.events.controllers;

import edu.lawrence.events.objects.Participant;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participants")
@CrossOrigin(origins="*")
public class ParticipantController {
    private ParticipantDAO dao;
    
    public ParticipantController(ParticipantDAO dao) {
        this.dao = dao;
    }
    
    @GetMapping(params={"event"})
    public List<Participant> participantsByEvent(@RequestParam int event) {
        return dao.findByEvent(event);
    }
    
    @PostMapping()
    public String addParticipant(@RequestBody Participant p) {
        dao.save(p);
        return "\"success\"";
    }
}
