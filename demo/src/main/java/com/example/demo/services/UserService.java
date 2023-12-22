package com.example.demo.services;

import com.example.demo.converters.ObjectConverter;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.models.dtos.UserDTO;
import com.example.demo.models.entities.User;
import com.example.demo.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Regular service class which performs the business logic.
@Service
public class UserService {

    // injection of repository
    private final UserRepository userRepository;
    // injection of boilerplate code of a converter.
    private final ObjectConverter<User, UserDTO> userConverter;

    public UserService(UserRepository userRepository,
                       ObjectConverter<User, UserDTO> userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    // this method gets the user for a give id and returns the DTO
    public UserDTO getUserById(Long id) {
        // getReferenceById is the default provided method in the JpaRepository,
        // and it will throw an exception if no record found, but we want to have full control over the exceptions
        //return userConverter.convertFirstToSecond(userRepository.getReferenceById(id));

        // here we search using the repository for a user
        // that method returns an optional, thus we have control over thrown exception
        User user = userRepository.getUserById(id)
                .orElseThrow(UserNotFoundException::new);
        // we convert the user to a UserDTO before returning it to the client.
        return userConverter.convertFirstToSecond(user);
    }

    // A simple method which validates the input received
    // converts it to the Entity annotated class
    // and persists it to the database
    public void saveUser(@Valid UserDTO userDTO) {
        userRepository.save(userConverter.convertSecondToFirst(userDTO));
    }

    // A simple method which deletes
    public void deleteUserById(Long id) {
        // this method can be used to delete entity by id;
        // but if the entity with that id is not present in the db, it will act like successfully deleted.
        // userRepository.deleteById(id);

        // alternatively, we can first get the user with that id and further to act differently based on that result.
        User user = userRepository.getUserById(id)
                .orElseThrow(UserNotFoundException::new);

        userRepository.delete(user);
    }

    // returning true or false if the user with the given id exists or not.
    public boolean updateUserDetails(Long id, UserDTO userDTO) {
        boolean isUserExisting = false;
        Optional<User> userById = userRepository.getUserById(id);
        User user;

        if (userById.isPresent()) {
            isUserExisting = true;
            user = userById.get();
        } else {
            user = new User();
        }

        updateUser(userDTO, user);
        userRepository.save(user);

        return isUserExisting;
    }

    // updating the user entity properties if they are sent out by the client or not.
    private static void updateUser(UserDTO userDTO, User user) {
        if (userDTO.age() != null)  {
            user.setAge(userDTO.age());
        }

        if (userDTO.name() != null)  {
            user.setName(userDTO.name());
        }

        if (userDTO.email() != null)  {
            user.setEmail(userDTO.email());
        }

        if (userDTO.country() != null)  {
            user.setCountry(userDTO.country());
        }
    }
}
