package com.RestAPI_Persona.controller;

import com.RestAPI_Persona.model.Persona;
import com.RestAPI_Persona.model.PersonaDTO;
import com.RestAPI_Persona.service.servicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    servicePersona servicePersona;

    @GetMapping()
    public String index(){
        return "CONECTADO";
    }

    @GetMapping("/personas")
    public List<Persona> getPersonsController() {

        System.out.println("Ingresando a Listar Personas");
        return servicePersona.getPersons();
    }

    @PostMapping("/guardarPersona")
    public ResponseEntity<?> savePersonController(@RequestBody Persona persona){

        System.out.println("Nombre persona a ingresar "+persona.getNombre());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(persona.getNombre()).toUri();

        servicePersona.savePerson(persona);
        //return "Persona "+persona.toString()+"grabada correctamente en el sistema";
        //return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente : "+customer.getUserName());
        return ResponseEntity.created(location).body(persona);
    }

    @PutMapping("/editarPersona/{id}")
    public ResponseEntity<?> editPersonController(@PathVariable Long id, @RequestBody Persona persona){

        System.out.println("EN EL METODO EDIT");
        Persona updatePersona = servicePersona.findPerson(id);

        if(updatePersona==null) {
            System.out.println("PERSONA ES NULO");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado : " + persona.getNombre());
        }else{
            System.out.println("PERSONA NO ES NULO : "+updatePersona.getNombre());
        }

        updatePersona.setNombre(persona.getNombre());
        updatePersona.setTelefono(persona.getTelefono());
        updatePersona.setUbicacion(persona.getUbicacion());
        updatePersona.setLogin(persona.getLogin());
        updatePersona.setPassword(persona.getPassword());
        servicePersona.savePerson(persona);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente actualizado exitosamente : "+persona);
    }

    @DeleteMapping("/borrarPersona/{id}")
    public ResponseEntity<?> borrarPersonController(@PathVariable Long id){
        Persona deletePersona = servicePersona.findPerson(id);
        servicePersona.deletePerson(deletePersona);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public PersonaDTO login(@RequestBody Persona persona) {
        return servicePersona.login(persona.getLogin(),persona.getPassword());
    }
}

