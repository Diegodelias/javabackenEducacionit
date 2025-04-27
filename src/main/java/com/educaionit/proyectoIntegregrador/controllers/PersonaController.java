package com.educaionit.proyectoIntegregrador.controllers;

import com.educaionit.proyectoIntegregrador.models.Persona;
import com.educaionit.proyectoIntegregrador.services.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/personas")

@PreAuthorize("permitAll()")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(@Autowired PersonaService personaService) {

        this.personaService = personaService;

    }


    @Operation(summary="Obtener todas las personas" , description="Obtiene todas las personas de algun lado")
    @ApiResponse(responseCode = "200" , description="Personas obtenidas correctamente")
    @GetMapping
    //@PreAuthorize("hasAuthority('READ')")
    @PreAuthorize("hasRole('ESTUDIANTE')")
    public List<Persona> getAllPersonas() {
        return personaService.getAll();

    }

    @ApiResponses({
        @ApiResponse(responseCode = "200" ,description = "exitos" ),
        @ApiResponse(responseCode = "404" ,description = "no existe" )
    })
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ')")
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
    @PreAuthorize("hasAnyRole('ADMIN','GERENTE')")
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {

        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        personaService.delete(id);
        return ResponseEntity.noContent().build();


    }


}
