package com.educaionit.proyectoIntegregrador.repositories;

import com.educaionit.proyectoIntegregrador.models.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository {

    private final List<Producto> productos = new ArrayList<>();

    public List<Producto> findAll() {

        return productos;


    }


    public Optional<Producto> findBy(Long id) {

        return productos.stream().filter(p -> p.getId().equals(id)).findFirst();


    }

    public Producto save(Producto persona) {
        productos.add(persona);
        return persona;
    }

    public void delete(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }


}
