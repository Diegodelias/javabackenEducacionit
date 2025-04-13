package com.educaionit.proyectoIntegregrador.services;

import com.educaionit.proyectoIntegregrador.models.Persona;
import com.educaionit.proyectoIntegregrador.models.Producto;
import com.educaionit.proyectoIntegregrador.repositories.PersonaRepository;
import com.educaionit.proyectoIntegregrador.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class ProductosService {

    private ProductoRepository productoRepository;

    public ProductosService(@Autowired ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    public Producto getById(Long id) {
        return productoRepository.findBy(id).orElseThrow(NoSuchElementException::new);
    }

    public Producto save(Producto producto) {
        return  productoRepository.save(producto);
    }

    public void delete(Long id) {

        productoRepository.delete(id);

    }
}
