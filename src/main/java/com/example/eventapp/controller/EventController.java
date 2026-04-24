package com.example.eventapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.eventapp.model.Event;
import com.example.eventapp.service.EventService;

@Controller
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("events", service.getAllEvents());
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("event", new Event());
        return "create";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event) {
        service.createEvent(event);
        return "redirect:/";
    }

    @GetMapping("/event/{id}")
    public String viewEvent(@PathVariable Long id, Model model) {
        model.addAttribute("event", service.getEvent(id));
        return "details";
    }

 /*  @PostMapping("/register/{id}")
    public String register(@PathVariable Long id,
                           @RequestParam String name,
                           @RequestParam String email,
                           Model model) {

        String message = service.registerUser(id, name, email);
        model.addAttribute("message", message);
        model.addAttribute("event", service.getEvent(id));

        return "details";
    }*/
    @PostMapping("/register/{id}")
public String register(@PathVariable Long id,
                       @RequestParam String name,
                       @RequestParam String email) {

    service.registerUser(id, name, email);

    // 🔥 AUTO REDIRECT TO HOMEPAGE
    return "redirect:/";
}

}