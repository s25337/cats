package com.pjatk.MPR;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import java.util.List;


@org.springframework.stereotype.Service
public class Service {

    RestClient restClient;
    public static final String API_URL = "http://localhost:8080";

    public Service() {
       restClient = RestClient.create();
    }

    public List<Cat> getAll() {
        List<Cat> cats = restClient
                .get()
                .uri(API_URL +"/cats")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return cats;
    }

    public void sendCat(Cat cat) {
        ResponseEntity<Void> response = restClient.post()
                .uri(API_URL + "/send")
                .contentType(MediaType.APPLICATION_JSON)
                .body(cat)
                .retrieve()
                .toBodilessEntity();
    }

    public void editCatName(Object cat, String name, String race) {
        ResponseEntity<Void> response = restClient.post()
                .uri(API_URL + "/edit/{id}")
                .contentType(MediaType.APPLICATION_JSON)
                .body(cat)
                .retrieve()
                .toBodilessEntity();
    }

    public void deleteCat(Object cat, String name, String race) {
        ResponseEntity<Void> response = restClient.post()
                .uri(API_URL + "/delete/{id}")
                .contentType(MediaType.APPLICATION_JSON)
                .body(cat)
                .retrieve()
                .toBodilessEntity();
    }
}
