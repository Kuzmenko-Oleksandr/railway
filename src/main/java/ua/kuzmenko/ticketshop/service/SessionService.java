package ua.kuzmenko.ticketshop.service;

import ua.kuzmenko.ticketshop.model.Session;
import ua.kuzmenko.ticketshop.model.Train;

import java.time.LocalDateTime;
import java.util.List;

public interface SessionService {
    List<Session> findAllByStartDateBetweenAndTrain(LocalDateTime from, LocalDateTime to, Train train);

    void save(Session session);

    void delete(Session session);
}
