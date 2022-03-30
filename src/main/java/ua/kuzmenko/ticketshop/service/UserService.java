package ua.kuzmenko.ticketshop.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.kuzmenko.ticketshop.model.User;

public interface UserService extends UserDetailsService {
  User findByLogin(String login);

  void save(User user);
}
