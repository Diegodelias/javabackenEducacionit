package com.educaionit.proyectoIntegregrador.controllers;

import com.educaionit.proyectoIntegregrador.models.Persona;
import com.educaionit.proyectoIntegregrador.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/personas")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(@Autowired PersonaService personaService) {

        this.personaService = personaService;

    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAll();

    }


    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonas(@PathVariable Long id) {
        try {

            return ResponseEntity.ok().body(personaService.getById(id));
            //   return  new ResponseEntity<>(personaService.getById(id), HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
            //  return new ResponseEntity(HttpStatus.NOT_FOUND);
        }


    }

    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {

        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        personaService.delete(id);
        return ResponseEntity.noContent().build();


    }


}
