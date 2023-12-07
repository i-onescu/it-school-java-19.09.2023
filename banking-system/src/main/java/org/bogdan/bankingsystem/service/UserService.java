package org.bogdan.bankingsystem.service;

import org.bogdan.bankingsystem.dto.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final List<User> KNOWN_USERS = new ArrayList<>();
    // we will keep an in-memory users counter.
    private static int NO_USERS = 3;

    // this is a static block
    // it is interpreted at the moment on class loading.
    static {
        KNOWN_USERS.add(new User(1, "Bogdan", 20, LocalDate.now()));
        KNOWN_USERS.add(new User(2, "Tiberiu", 21, LocalDate.of(2022, 10, 10)));
        KNOWN_USERS.add(new User(3, "Razvan", 22, LocalDate.of(2023, 1, 1)));
    }

    public List<User> getKnownUsers() {
        return KNOWN_USERS;
    }

    public User getUserById(int id) {
        return KNOWN_USERS.stream()
                .filter(user -> id == user.getId())
                .findFirst()
                .orElseThrow();
    }

    public void deleteUserById(int id) {
        User user = KNOWN_USERS.stream()
                .filter(u -> id == u.getId())
                .findFirst()
                .orElseThrow();

        KNOWN_USERS.remove(user);
    }

    public User getUserByIdAndName(int id, String name) {
        return KNOWN_USERS.stream()
                .filter(u -> id == u.getId() && name.equals(u.getName()))
                .findFirst()
                .orElseThrow();
    }

    public User createUser(User user) {
        user.setId(NO_USERS++);
        KNOWN_USERS.add(user);

        return user;
    }

    public User updateUser(Integer id, User user) {
        User newUser = KNOWN_USERS.stream()
                .filter(u -> id == u.getId())
                .findFirst()
                .orElseGet(User::new);

        newUser.setName(user.getName());
        newUser.setAge(user.getAge());
        newUser.setJoinDate(user.getJoinDate());

        if (newUser.getId() == 0) {
            user.setId(NO_USERS++);
            KNOWN_USERS.add(user);
        }

        return newUser;
    }
}
