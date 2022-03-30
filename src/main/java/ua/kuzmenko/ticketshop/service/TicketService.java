package ua.kuzmenko.ticketshop.service;

import org.springframework.stereotype.Service;
import ua.kuzmenko.ticketshop.model.Session;
import ua.kuzmenko.ticketshop.model.Ticket;
import ua.kuzmenko.ticketshop.model.User;

import java.util.List;

@Service
public interface TicketService {
    List<Ticket> findAllByUser(User user);

    void save(Ticket ticket);

    int countAllBySession(Session session);

    List<Ticket> findAllBySession(Session session);

    Ticket findByRowAndSeatAndSession(int row, int seat, Session session);

    void delete(Ticket ticket);


}
