package com.example.eventapp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.eventapp.model.*;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Optional<Registration> findByEmailAndEvent(String email, Event event);
}