package org.bogdan.bankingsystem.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.bogdan.bankingsystem.dto.User;
import org.bogdan.bankingsystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Rest controller sends back bodies (or payloads of data)
// @Controller returns back views (rendered html)
@RestController
// @RequestMapping placed at class level ensures that
// this class will handle any request coming on the given path
@RequestMapping("/users")
// This annotation provides a logger. It can be accessed using 'log' variable in any method
// This annotation comes from Lombok.
@Slf4j
public class UserController {

    // injected the UserService instance through constructor
    // usually there should be a minimum amount of logic present at controller level
    // this is why we have a service.
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping handles the GET requests
    // so any request on http://localhost:8080/users will return back the list of users.
    @GetMapping
    // We can return any kind of Object as it will be translated into JSON (a list will become an array in JSON),
    // but if the response code always is 200 and might not respect all the business requirements,
    // for example, for POST methods we need 201 Created.
    public List<User> getUsers() {
        return userService.getKnownUsers();
    }

    // http://localhost:8080/users/{id}
    // http://localhost:8080/users

    // equivalent
    // @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    // We can pass a path as param for @GetMapping annotation (the same for all methods)
    // If we want to inject a path variable we must use a pair of curly braces to enclose the param identifier (our case 'id')
    @GetMapping("/{id}")
    // Use @PathVariable() to capture the path variable, the param identifier must be the same (e.g. 'id')
    // Note that we have here ResponseEntity, this is a wrapper around the returned type
    // it allows us to provide descriptive responses.
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        log.info("Getting user with id " + id);

        // this will set the response status 200 OK.
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/user")
    // We can also pass the parameters as request parameters
    // e.g. http://localhost:8080/users/user?id=1
    // if you have multiple params:
    // e.g. http://localhost:8080/users/user?id=1&name=test
    // the above request can get the user with id 1 and name test
    // in order to capture such parameters we use the @RequestParam annotation with the corresponding param identifier.
    public ResponseEntity<User> getUserByIdInReqParam(@RequestParam("id") Integer id) {
        log.info("Getting user with id " + id);

        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/user-name")
    public ResponseEntity<User> getUserByIdAndNameInReqParam(@RequestParam(value = "id", required = false) Integer id,
                                                             @RequestParam(value = "name") String name) {
        log.info("Getting user with id " + id);

        return ResponseEntity.ok(userService.getUserByIdAndName(id, name));
    }

    // equivalent
    // @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    // The DELETE method usually removes a resource
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        log.info("Removing user with id " + id);

        userService.deleteUserById(id);
        return "deleted";
    }

    // POST method creates a new resource
    @PostMapping
    // You can also pass objects as parameters in requests
    // In order to keep requests clean and short, for POST you can use bodies (payloads)
    // We need @RequestBody to capture the request. Now we don't need any param identifier
    // as you can't send more than one payload per request
    // The payload sent must respect the class fields (referring to names).
    // In order to enable the validations on the payload add the annotation @Valid.
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        // Here we return the HTTP Status code of 201 Created
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    // PUT will update an existing resource, or create a new one in case it does not exist
    // note that you can also combine the ways of capturing parameters (path + req body).
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        // Here we return the HTTP Status code of 202 Accepted
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.ACCEPTED);
    }
}
