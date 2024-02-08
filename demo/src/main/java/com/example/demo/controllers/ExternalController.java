package com.example.demo.controllers;

import com.example.demo.models.dtos.ResponsePayload;
import com.example.demo.models.dtos.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/external")
public class ExternalController {

    @GetMapping
    public String getExternal() {
        RestTemplate restTemplate = new RestTemplate();

        ResponsePayload forObject = restTemplate.getForObject("http://localhost:8080/api/v1/user/2", ResponsePayload.class);
//        ResponseEntity<ResponsePayload> response = restTemplate.getForEntity("http://localhost:8080/api/v1/user/2", ResponsePayload.class);

        System.out.println(forObject.response());
        return "External";
    }

    @GetMapping("/json")
    public String getExternalWithPlainJson() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> forObject =
                restTemplate.getForEntity("http://localhost:8080/api/v1/user/1", String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(forObject.getBody());
        JsonNode response = jsonNode.path("response");
        JsonNode country = response.path("country");
        System.out.println(country.asText());

        return "External";
    }

    @GetMapping("/head")
    public String headExternal() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = restTemplate.headForHeaders("http://localhost:8080/api/v1/user/1");
        System.out.println(headers.getContentType());

        return "External";
    }

    @PostMapping
    public String postExternal() {
        RestTemplate restTemplate = new RestTemplate();
        UserDTO userDTO = new UserDTO("John", null, "john@test.com", 18);

        try {
            restTemplate.postForEntity("http://localhost:8080/api/v1/user", userDTO, Void.class);
        } catch (HttpClientErrorException clientErrorException) {
            System.out.println("User's fault!");
        } catch (HttpServerErrorException serverErrorException) {
            System.out.println("Server's fault!");
        }

        return "External";
    }

    @GetMapping("/exchange")
    public String exchangeExternal() {
        RestTemplate restTemplate = new RestTemplate();
        UserDTO userDTO = new UserDTO("John", "Romania", "john@test.com", 18);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer");

        HttpEntity<UserDTO> userDTOHttpEntity = new HttpEntity<>(userDTO, headers);

        ResponseEntity<ResponsePayload> exchange =
                restTemplate.exchange("http://localhost:8080/api/v1/user",
                        HttpMethod.POST, userDTOHttpEntity, ResponsePayload.class);

        ResponsePayload body = exchange.getBody();
        System.out.println(body.response());

        return "External";
    }

    @PutMapping
    public String putExchange() {
        RestTemplate restTemplate = new RestTemplate();
        UserDTO userDTO = new UserDTO("Johnny", "Romania", null, null);

        HttpEntity<UserDTO> userDTOHttpEntity = new HttpEntity<>(userDTO, new HttpHeaders());

        ResponseEntity<Void> exchange = restTemplate.exchange("http://localhost:8080/api/v1/user/1",
                HttpMethod.PUT, userDTOHttpEntity, Void.class);

        System.out.println(exchange.getBody());
        return "External";
    }

    @PutMapping("/callback")
    public String putExchangeCallback() {
        String resourceUrl
                = "http://localhost:8080/api/v1/user/1";

        RestTemplate restTemplate = new RestTemplate();
        UserDTO userDTO = new UserDTO("Johnny", "Romania", null, null);

        RequestCallback requestCallback = request -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(request.getBody(), userDTO);

            request.getHeaders().set("Content-Type", "application/json");
        };

        ResponseExtractor<Void> responseExtractor = response -> {
            Path p = Paths.get("src/test/resources/test.txt");
            Files.copy(response.getBody(), p);

            return null;
        };

        restTemplate.execute(resourceUrl,
                HttpMethod.PUT,
                requestCallback,
                responseExtractor);

        return "External";
    }

    @GetMapping("/httpclient")
    public String httpClient() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/v1/user/1"))
                .GET()
                .header("Authorization", "bearer")
                .headers()
                .build();

        HttpResponse<InputStream> send = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());

        Path p = Paths.get("src/test/resources/test.txt");
        Files.copy(send.body(), p);

        return "External";
    }
}
