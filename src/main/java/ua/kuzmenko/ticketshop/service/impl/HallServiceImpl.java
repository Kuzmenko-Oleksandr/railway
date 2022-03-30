package ua.kuzmenko.ticketshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kuzmenko.ticketshop.model.Hall;
import ua.kuzmenko.ticketshop.repository.HallRepository;
import ua.kuzmenko.ticketshop.service.HallService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HallServiceImpl implements HallService {
    private final HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public List<Hall> findAll() {
        return this.hallRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Hall hall) {
        this.hallRepository.save(hall);
    }

    @Override
    public Hall findByNumber(String hallNumber) {
        return this.hallRepository.findByNumber(Integer.parseInt(hallNumber));
    }
}
