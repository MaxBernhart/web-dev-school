package edu.lawrence.events.controllers;

import edu.lawrence.events.objects.Handle;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/handles")
@CrossOrigin(origins="*")
public class HandleController {
    private HandleDAO dao;
    
    public HandleController(HandleDAO dao) {
        this.dao = dao;
    }
    
    @GetMapping()
    public List<Handle> fetchAll() {
        return dao.findAll();
    }
    
}
