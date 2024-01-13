package com.example.demo.services;

import com.example.demo.converters.ObjectConverter;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.models.dtos.UserDTO;
import com.example.demo.models.entities.User;
import com.example.demo.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

// Regular service class which performs the business logic.
@Service
@Slf4j
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

    // throws marks that a method will throw a list of exceptions
    // but it won't bother with their handling.
    // thus, the caller have to handle them.
    private void doSomething(Long id) throws IOException, SQLException {
        int x = 1;
        if (x < 1) {
            doSomethingElse(id);
        } else if (x == 1) {
            throw new IOException("io");
        } else {
            throw new SQLException("ex");
        }
    }

    private void tryCatch() {
        int x = 1;
        try {
            if (x < 1) {
                throw new UserNotFoundException("test");
            } else if (x == 1) {
                throw new IOException("io");
            } else {
                throw new SQLException("ex");
            }
            // be careful about the hierarchy levels of exceptions
            // as the catch clauses are interpreted one by one
            // if a higher rank exception is placed first then it will catch
            // also the lower rank exceptions placed below leading to a compilation error.
        } catch (IOException e) {
            log.error(e.getMessage());
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    private void commonTryCatchBlocks() {
        int x = 1;

        try {
            if (x < 1) {
                throw new UserNotFoundException("test");
            } else if (x == 1) {
                throw new IOException("io");
            } else {
                throw new SQLException("ex");
            }
            // if the handling code is the same for two exceptions,
            // then you can have a common try catch block
        } catch (IOException | SQLException e) {
            log.error(e.getMessage());
        }
    }

    private void doSomethingElse(Long id) {
        throw new UserNotFoundException("test", id);
    }
}
