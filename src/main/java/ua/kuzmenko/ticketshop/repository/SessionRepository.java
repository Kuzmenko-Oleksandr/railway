package ua.kuzmenko.ticketshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kuzmenko.ticketshop.model.Session;
import ua.kuzmenko.ticketshop.model.Train;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findAllByStartDateBetweenAndTrain(LocalDateTime from, LocalDateTime to, Train train);
}
