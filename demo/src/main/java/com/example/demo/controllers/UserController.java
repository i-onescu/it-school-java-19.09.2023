package com.example.demo.controllers;

import com.example.demo.controllers.util.ResponseBuilderHelper;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.models.dtos.ResponsePayload;
import com.example.demo.models.dtos.UserDTO;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// regular rest controller accepting requests on:
// http://localhost:8080/api/v1/user
@RestController
@RequestMapping("/user")
public class UserController {

    // UserService injection through constructor
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GetMapping which tries to get the user for a given id.
    // try-catch mechanism, so we control the answer to the client.
    @GetMapping("/{id}")
    public ResponseEntity<ResponsePayload> getUserById(@PathVariable("id") Long id) {
        try {
            return ResponseBuilderHelper.buildResponsePayload(userService.getUserById(id),
                    HttpStatus.FOUND);
        } catch (UserNotFoundException e) {
            return ResponseBuilderHelper.buildResponsePayload(String.format("User with id %d not found!", id),
                    HttpStatus.NOT_FOUND);
        }
    }

    // PostMapping to save a user.
    // The payload is captured using @RequestBody
    // try-catch mechanism, so we control the answer to the client.
    @PostMapping
    public ResponseEntity<ResponsePayload> saveUser(@RequestBody UserDTO userDTO) {
        try {
            userService.saveUser(userDTO);
            return ResponseBuilderHelper.buildResponsePayload("User created!",
                    HttpStatus.CREATED);
        } catch (ValidationException e) {
            return ResponseBuilderHelper.buildResponsePayload("Wrong request!",
                    HttpStatus.BAD_REQUEST);
        }
    }

    // DeleteMapping to save a user.
    // There is a try-catch mechanism in case there is no user corresponding to the given id.
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponsePayload> deleteUserById(@PathVariable Long id) {
        try {
            userService.deleteUserById(id);
            // we will simply return NO_CONTENT http status code in case of deletion.
            // It would also work with OK, and you can provide some feedback to the user.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (UserNotFoundException e) {
            return ResponseBuilderHelper.buildResponsePayload(String.format("User with id %d not found!", id),
                    HttpStatus.NOT_FOUND);
        }
    }

    // PutMapping used to either update or create a new user
    // in case of that the id doesn't match any user from the database.
    // The validations are still in place, so we still need the try-catch mechanism.
    @PutMapping("/{id}")
    public ResponseEntity<ResponsePayload> updateUserDetails(@RequestBody UserDTO userDTO,
                                                             @PathVariable("id") Long id){
        try {
            // we send out a specific status code depending on
            // if the user was found or not in the database.
            return userService.updateUserDetails(id, userDTO)
                    ? ResponseBuilderHelper.buildResponsePayload("User updated!",
                        HttpStatus.OK)
                    : ResponseBuilderHelper.buildResponsePayload("User updated!",
                        HttpStatus.CREATED);
        } catch (ValidationException e) {
            return ResponseBuilderHelper.buildResponsePayload(String.format("Cannot update user with id %d!", id),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
