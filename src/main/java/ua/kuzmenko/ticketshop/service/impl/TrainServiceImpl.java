package ua.kuzmenko.ticketshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kuzmenko.ticketshop.model.Status;
import ua.kuzmenko.ticketshop.model.Train;
import ua.kuzmenko.ticketshop.repository.TrainRepository;
import ua.kuzmenko.ticketshop.service.TrainService;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {
    private final TrainRepository trainRepository;

    @Autowired
    public TrainServiceImpl(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Override
    public void save(Train train) {
        train.setStatus(Status.ACTIVE);
        this.trainRepository.save(train);
    }

    @Override
    public List<Train> findAll() {
        return this.trainRepository.findAll();
    }

    @Override
    public List<Train> findAllActive() {
        return this.trainRepository.findAllByStatusEquals(Status.ACTIVE);
    }

    @Override
    public Train findByName(String name) {
        return this.trainRepository.findByName(name);
    }
}
