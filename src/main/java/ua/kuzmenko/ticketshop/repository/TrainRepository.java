package ua.kuzmenko.ticketshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kuzmenko.ticketshop.model.Status;
import ua.kuzmenko.ticketshop.model.Train;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findAllByStatusEquals(Status status);
    Train findByName(String name);
}
