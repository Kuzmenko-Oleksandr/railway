package ua.kuzmenko.ticketshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kuzmenko.ticketshop.model.Hall;
import ua.kuzmenko.ticketshop.repository.HallRepository;

@Service
public class AddDefaultHall {

  private final HallServiceImpl hallService;
  private final HallRepository hallRepository;

  @Autowired
  public AddDefaultHall(HallServiceImpl hallService, HallRepository hallRepository) {
    this.hallService = hallService;
    this.hallRepository = hallRepository;
  }

  public void createDefaultHall() {
    Hall hall = new Hall();
    Hall hall2 = new Hall();
    hall2.setNumber(1);
    hall2.setNumberOfSeats(20);
    hall.setNumber(10);
    hall.setNumberOfSeats(20);
    if (hallRepository.findByNumber(hall.getNumber()) == null && hallRepository.findByNumber(hall2.getNumber()) == null) {
      hallService.save(hall);
      hallService.save(hall2);
    }
  }
}
