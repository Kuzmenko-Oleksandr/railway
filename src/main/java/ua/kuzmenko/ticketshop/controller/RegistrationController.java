package ua.kuzmenko.ticketshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kuzmenko.ticketshop.model.Role;
import ua.kuzmenko.ticketshop.model.User;
import ua.kuzmenko.ticketshop.service.UserService;
import ua.kuzmenko.ticketshop.service.impl.AddDefaultHall;
import ua.kuzmenko.ticketshop.service.impl.RegisterDefaultUser;

import java.util.Collections;

@Controller
public class RegistrationController {
  private final UserService userService;

  private final RegisterDefaultUser defaultUser;

  private final AddDefaultHall addDefaultHall;

  @Autowired
  public RegistrationController(UserService userService, RegisterDefaultUser defaultUser, AddDefaultHall addDefaultHall) {
    this.userService = userService;
    this.defaultUser = defaultUser;
    this.addDefaultHall = addDefaultHall;
  }


  @GetMapping("/registration")
  public String registration() {
    return "registration";
  }

  @PostMapping("/registration")
  public String addUser(User user, Model model) {
    User userFromDb = userService.findByLogin(user.getLogin());

    if (userFromDb != null) {
      model.addAttribute("message", "User already exists!");
      return "registration";
    }

    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));
    userService.save(user);
    defaultUser.defaultUser();
    addDefaultHall.createDefaultHall();
    return "redirect:/login";
  }

}
