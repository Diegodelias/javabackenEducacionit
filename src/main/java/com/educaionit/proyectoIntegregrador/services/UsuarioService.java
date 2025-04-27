package com.educaionit.proyectoIntegregrador.services;


import com.educaionit.proyectoIntegregrador.models.Producto;
import com.educaionit.proyectoIntegregrador.models.Usuario;
import com.google.gson.JsonArray;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioService {


    public Usuario getRandomUser() {
        String url = "https://randomuser.me/api/";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        Usuario us = new Usuario();
        // Procesar la respuesta con Gson



        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        JsonArray results = jsonObject.getAsJsonArray("results");
        JsonObject user = results.get(0).getAsJsonObject();
        String nombre =  results.get(0).getAsJsonObject().getAsJsonObject("name").get("first").getAsString();
        String apellido =  results.get(0).getAsJsonObject().getAsJsonObject("name").get("last").getAsString();

        String email = user.get("email").getAsString();
        String telefono = user.get("phone").getAsString();
        String cell = user.get("cell").getAsString();



       //Usuario usu = gson.fromJson(response , Usuario.class );
        us.setNombre(nombre);
        us.setApellido(apellido);
        us.setEmail(email);
        us.setTelefono(telefono);
        us.setCelular(cell);



        return us;
    }


    public List<Usuario> getRandomUserByQuantity(int cantidad) {
        String url = "https://randomuser.me/api/?results="+cantidad;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        List<Usuario> lista = new ArrayList<>();

        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        JsonArray results = jsonObject.getAsJsonArray("results");

        for (int i = 0; i < results.size(); i++) {
            Usuario us = new Usuario();
            JsonObject user = results.get(i).getAsJsonObject();
            String nombre =  results.get(i).getAsJsonObject().getAsJsonObject("name").get("first").getAsString();
            String apellido =  results.get(i).getAsJsonObject().getAsJsonObject("name").get("last").getAsString();
            String email = user.get("email").getAsString();
            String telefono = user.get("phone").getAsString();
            String cell = user.get("cell").getAsString();
            us.setNombre(nombre);
            us.setApellido(apellido);
            us.setEmail(email);
            us.setTelefono(telefono);
            us.setCelular(cell);
            lista.add(us);




        }





        return lista;

    }



}
