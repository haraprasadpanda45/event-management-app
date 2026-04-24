package com.example.eventapp.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.eventapp.model.*;
import com.example.eventapp.repository.*;

@Service
public class EventService {

    private final EventRepository eventRepo;
    private final RegistrationRepository regRepo;

    public EventService(EventRepository eventRepo, RegistrationRepository regRepo) {
        this.eventRepo = eventRepo;
        this.regRepo = regRepo;
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepo.save(event);
    }

    public Event getEvent(Long id) {
        return eventRepo.findById(id).orElseThrow();
    }

    public String registerUser(Long eventId, String name, String email) {

        Event event = getEvent(eventId);

        Optional<Registration> existing =
                regRepo.findByEmailAndEvent(email, event);

        if (existing.isPresent()) {
            return "Already registered!";
        }

        Registration reg = new Registration();
        reg.setName(name);
        reg.setEmail(email);
        reg.setEvent(event);

        regRepo.save(reg);

        return "Registration successful!";
    }
}