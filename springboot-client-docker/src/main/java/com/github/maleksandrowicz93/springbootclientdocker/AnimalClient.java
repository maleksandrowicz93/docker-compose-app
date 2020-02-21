package com.github.maleksandrowicz93.springbootclientdocker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AnimalClient {

    @Value("${HOST_NAME}")
    private String HOST_NAME;

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/showForGui")
    public Animal[] get() {

        ResponseEntity<Animal[]> exchange = restTemplate.exchange("http://" + HOST_NAME + ":9090/animals",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Animal[].class);

        return exchange.getBody();
    }

    @PostMapping("/showForGui")
    public void addAnimal(@RequestBody Animal animal) {

        restTemplate.postForObject("http://" + HOST_NAME + ":9090/animals", animal, String.class);
    }

}
