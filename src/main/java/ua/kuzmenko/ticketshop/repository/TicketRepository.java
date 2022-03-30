package ua.kuzmenko.ticketshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kuzmenko.ticketshop.model.Session;
import ua.kuzmenko.ticketshop.model.Ticket;
import ua.kuzmenko.ticketshop.model.User;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    int countAllBySession(Session session);
    List<Ticket> findAllByUser(User user);
    List<Ticket> findAllBySession(Session session);
    Ticket findByRowAndSeatAndSession(int row, int seat, Session session);
}
