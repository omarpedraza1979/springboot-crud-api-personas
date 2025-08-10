package com.RestAPI_Persona.service;

import com.RestAPI_Persona.model.Persona;
import com.RestAPI_Persona.model.PersonaDTO;
import com.RestAPI_Persona.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class servicePersona {

    @Autowired
    Repository personaRepo;

    public List<Persona> getPersons() {
        return personaRepo.findAll();
    }

    public void savePerson(@RequestBody Persona persona){
        try {
            personaRepo.save(persona);
        } catch (ObjectOptimisticLockingFailureException e) {
            System.out.println("Error grabando persona : "+e.getMessage());
        }
    }

    public Persona findPerson(@PathVariable Long id){
            return personaRepo.findById(id).get();
    }

    public void deletePerson(Persona deletePersona){
        personaRepo.delete(deletePersona);
    }

    public PersonaDTO login(String login, String password){
        System.out.println("SALIDA DEL METODO = "+ personaRepo.findByLoginAndPassword(login,password));

        Persona persona =  personaRepo.findByLoginAndPassword(login,password);
        PersonaDTO personaDTO = new PersonaDTO(persona.getNombre(), persona.getTelefono(), persona.getUbicacion());

        return personaDTO;
    }

}
