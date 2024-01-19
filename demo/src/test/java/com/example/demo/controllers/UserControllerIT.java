package com.example.demo.controllers;

import com.example.demo.models.dtos.ResponsePayload;
import com.example.demo.models.dtos.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIT {

    @Autowired
    private MockMvc mvc;

    @Test
    void testSaveUser() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .name("John")
                .age(18)
                .email("john@doe.com")
                .country("Romania")
                .build();

        mvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writeObjectAsJson(userDTO)))
                .andExpect(status().is(201));

        mvc.perform(MockMvcRequestBuilders.get("/user/1"))
                .andExpect(status().is(302))
                .andExpect(result -> assertEquals(buildUserDTOAsMap(userDTO),
                        readJsonAsObject(result.getResponse().getContentAsString())));
    }

    @Test
    void testSaveUser_andWrongPayload() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .name("John")
                .age(18)
                .email("john@doe.com")
                .country("Romania3433")
                .build();

        mvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writeObjectAsJson(userDTO)))
                .andExpect(status().is(400));
    }

    private String writeObjectAsJson(Object obj) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private ResponsePayload readJsonAsObject(String json) {
        ObjectReader or = new ObjectMapper().reader();
        try {
            return or.readValue(json, ResponsePayload.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ResponsePayload buildUserDTOAsMap(UserDTO userDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper
                .convertValue(userDTO, new TypeReference<>() {});

        return ResponsePayload.builder()
                .response(map)
                .statusCode(HttpStatus.FOUND.name())
                .build();
    }
}
