package com.educaionit.proyectoIntegregrador.repositories;

import com.educaionit.proyectoIntegregrador.models.Persona;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PersonaRepository {

    private final List<Persona> personas = new ArrayList<>();

    public List<Persona> findAll() {

        return personas;


    }


    public Optional<Persona> findBy(Long id) {

        return personas.stream().filter(p -> p.getId().equals(id)).findFirst();


    }

    public Persona save(Persona persona) {
        personas.add(persona);
        return persona;
    }

    public void delete(Long id) {
        personas.removeIf(p -> p.getId().equals(id));
    }

}
