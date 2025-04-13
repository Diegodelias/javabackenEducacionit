package com.educaionit.proyectoIntegregrador.controllers;

import com.educaionit.proyectoIntegregrador.models.Persona;
import com.educaionit.proyectoIntegregrador.models.Producto;
import com.educaionit.proyectoIntegregrador.services.PersonaService;
import com.educaionit.proyectoIntegregrador.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;



@RestController
@RequestMapping("/productos")
public class ProductoController {



    private ProductosService productoService;

    public ProductoController(@Autowired ProductosService productoService) {

        this.productoService = productoService;

    }

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAll();

    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductos(@PathVariable Long id) {
        try {

            return ResponseEntity.ok().body(productoService.getById(id));
            //   return  new ResponseEntity<>(personaService.getById(id), HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
            //  return new ResponseEntity(HttpStatus.NOT_FOUND);
        }


    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();


    }










}
