package ua.kuzmenko.ticketshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kuzmenko.ticketshop.model.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
    Hall findByNumber(int number);
}
