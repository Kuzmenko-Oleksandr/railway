package ua.kuzmenko.ticketshop.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Hall {
    @Column(name = "number")
    int number;
    @Column(name = "number_of_seats")
    int numberOfSeats;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "hall")
    @ToString.Exclude
    private List<Session> sessions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Hall hall = (Hall) o;
        return id != null && Objects.equals(id, hall.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

