package com.RestAPI_Persona.repository;

import com.RestAPI_Persona.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Persona, Long> {
   public Persona findByLoginAndPassword(String login, String password);
}
