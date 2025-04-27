package com.educaionit.proyectoIntegregrador.controllers;

import com.educaionit.proyectoIntegregrador.models.Persona;
import com.educaionit.proyectoIntegregrador.models.Producto;
import com.educaionit.proyectoIntegregrador.services.PersonaService;
import com.educaionit.proyectoIntegregrador.services.ProductosService;
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
@RequestMapping("/productos")
@PreAuthorize("permitAll()")
public class ProductoController {



    private ProductosService productoService;

    public ProductoController(@Autowired ProductosService productoService) {

        this.productoService = productoService;

    }

    @Operation(summary="Obtener todas las personas" , description="Obtiene todos los productos de algun lado")
    @ApiResponse(responseCode = "200" , description="Personas obtenidas correctamente")
    @GetMapping
    @PreAuthorize("hasRole('ESTUDIANTE')")
    public List<Producto> getAllProductos() {
        return productoService.getAll();

    }

    @ApiResponses({
        @ApiResponse(responseCode = "200" ,description = "exitos" ),
        @ApiResponse(responseCode = "404" ,description = "no existe" )
    })
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('GERENTE')")
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
    @PreAuthorize("hasAnyRole('ADMIN','GERENTE')")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();


    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto existingProducto = productoService.getById(id);
        if (existingProducto != null) {
            existingProducto.setNombre(productoDetails.getNombre());
            existingProducto.setDescripcion(productoDetails.getDescripcion());
            existingProducto.setId(productoDetails.getId());
            existingProducto.setPrecio(productoDetails.getPrecio());
            existingProducto.setUrlFoto(productoDetails.getUrlFoto());
            return ResponseEntity.ok(existingProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/")
    public ResponseEntity<Producto> getByNombre(@RequestParam String nombre) {

        Producto producto = productoService.getByNombre(nombre);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }












}
