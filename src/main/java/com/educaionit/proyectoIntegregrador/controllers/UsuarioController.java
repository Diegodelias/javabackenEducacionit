package com.educaionit.proyectoIntegregrador.controllers;


import com.educaionit.proyectoIntegregrador.models.Persona;
import com.educaionit.proyectoIntegregrador.models.Producto;
import com.educaionit.proyectoIntegregrador.models.Usuario;
import com.educaionit.proyectoIntegregrador.services.PersonaService;
import com.educaionit.proyectoIntegregrador.services.ProductosService;
import com.educaionit.proyectoIntegregrador.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(@Autowired UsuarioService usuarioService) {

        this.usuarioService = usuarioService;

    }


    @GetMapping("/get")
    public ResponseEntity<Usuario> getUsuarios() {

       // usuarioService.getRandomUser();

        try {
        return ResponseEntity.ok().body(usuarioService.getRandomUser());

        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
            //  return new ResponseEntity(HttpStatus.NOT_FOUND);
        }


    }





    @GetMapping("/")
    public ResponseEntity<List<Usuario>>getUsuariosPorCantidad(@RequestParam int cantidadMaxima) {
        try {
            List<Usuario> lista = usuarioService.getRandomUserByQuantity(cantidadMaxima);
            return ResponseEntity.ok(lista);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {

            return ResponseEntity.internalServerError().build();
        }

    }



}
