package ua.kuzmenko.ticketshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kuzmenko.ticketshop.model.Role;
import ua.kuzmenko.ticketshop.model.User;
import ua.kuzmenko.ticketshop.service.UserService;

import java.util.Collections;

@Service
public class RegisterDefaultUser {

    private final UserService userService;

    @Autowired
    public RegisterDefaultUser(UserService userService) {
        this.userService = userService;
    }

    public void defaultUser() {
        User userFromDb = userService.findByLogin("admin");
        User user = new User();
        user.setFirstName("ADMIN");
        user.setLastName("ADMIN");
        user.setLogin("admin");
        user.setPassword("admin");
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ADMIN));
        if (userFromDb == null) {
            userService.save(user);
        }
    }
}
