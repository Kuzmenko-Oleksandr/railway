package ua.kuzmenko.ticketshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kuzmenko.ticketshop.model.Session;
import ua.kuzmenko.ticketshop.model.Ticket;
import ua.kuzmenko.ticketshop.model.User;
import ua.kuzmenko.ticketshop.repository.TicketRepository;
import ua.kuzmenko.ticketshop.service.TicketService;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> findAllByUser(User user) {
        return this.ticketRepository.findAllByUser(user);
    }

    @Override
    public void save(Ticket ticket) {
        this.ticketRepository.save(ticket);
    }

    @Override
    public void delete(Ticket ticket) {
        this.ticketRepository.delete(ticket);
    }

    @Override
    public int countAllBySession(Session session) {
        return this.ticketRepository.countAllBySession(session);
    }

    @Override
    public List<Ticket> findAllBySession(Session session) {
        return this.ticketRepository.findAllBySession(session);
    }

    @Override
    public Ticket findByRowAndSeatAndSession(int row, int seat, Session session) {
        return this.ticketRepository.findByRowAndSeatAndSession(row, seat, session);
    }
}
