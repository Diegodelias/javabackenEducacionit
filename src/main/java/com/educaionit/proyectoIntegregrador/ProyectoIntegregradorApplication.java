package com.educaionit.proyectoIntegregrador;


import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProyectoIntegregradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoIntegregradorApplication.class, args);

       /* RestTemplate restTemplate = new RestTemplate();

        String url = "https://randomuser.me/api/";


        String json = restTemplate.getForObject(url, String.class);

        Gson gson = new Gson();
        RandomUserResponse response = gson.fromJson(json, RandomUserResponse.class);
        System.out.println(response.getResults().;

*/

        /*ResponseEntity<ApiResponse> response = restTemplate.getForEntity(API_URL, ApiResponse.class);
        return response.getBody();*/










	}

}
