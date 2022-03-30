package ua.kuzmenko.ticketshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kuzmenko.ticketshop.model.Session;
import ua.kuzmenko.ticketshop.model.Train;
import ua.kuzmenko.ticketshop.repository.SessionRepository;
import ua.kuzmenko.ticketshop.service.SessionService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public List<Session> findAllByStartDateBetweenAndTrain(LocalDateTime from, LocalDateTime to, Train train) {
        return this.sessionRepository.findAllByStartDateBetweenAndTrain(from, to, train);
    }

    @Override
    public void save(Session session) {
        this.sessionRepository.save(session);
    }

    @Override
    public void delete(Session session) {
        this.sessionRepository.delete(session);
    }

}
