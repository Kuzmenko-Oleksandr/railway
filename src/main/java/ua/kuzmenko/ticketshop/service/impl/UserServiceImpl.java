package ua.kuzmenko.ticketshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.kuzmenko.ticketshop.model.User;
import ua.kuzmenko.ticketshop.repository.UserRepository;
import ua.kuzmenko.ticketshop.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User findByLogin(String login) {
    return userRepository.findByLogin(login);
  }

  @Override
  public void save(User user) {
    this.userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    return userRepository.findByLogin(s);
  }
}
