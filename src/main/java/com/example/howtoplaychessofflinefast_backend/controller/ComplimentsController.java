package com.example.howtoplaychessofflinefast_backend.controller;

import com.example.howtoplaychessofflinefast_backend.service.ComplimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/compliments")
public class ComplimentsController {

    private final ComplimentsService complimentsService;

    @Autowired
    public ComplimentsController(ComplimentsService complimentsService) {
        this.complimentsService = complimentsService;
    }

    @GetMapping(path = "/getCompliment")
    public String getCompliment() {
        return complimentsService.getRandomCompliment();
    }

    @PostMapping(path = "/addCompliment/{compliment}")
    public String AddCompliment(@PathVariable("compliment") String compliment) throws Exception {
        return complimentsService.addCompliment(compliment);
    }
}
