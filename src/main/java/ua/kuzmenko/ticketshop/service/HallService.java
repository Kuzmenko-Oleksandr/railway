package ua.kuzmenko.ticketshop.service;

import ua.kuzmenko.ticketshop.model.Hall;

import java.util.List;

public interface HallService {
  List<Hall> findAll();

  void save(Hall hall);

  Hall findByNumber(String hallNumber);
}
