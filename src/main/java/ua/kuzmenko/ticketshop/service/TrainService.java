package ua.kuzmenko.ticketshop.service;

import ua.kuzmenko.ticketshop.model.Train;

import java.util.List;

public interface TrainService {
    void save(Train train);

    List<Train> findAll();

    List<Train> findAllActive();

    Train findByName(String name);
}
