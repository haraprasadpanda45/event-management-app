package com.example.eventapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.eventapp.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}