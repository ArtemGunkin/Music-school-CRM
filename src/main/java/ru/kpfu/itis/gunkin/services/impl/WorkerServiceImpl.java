package ru.kpfu.itis.gunkin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.gunkin.entities.Worker;
import ru.kpfu.itis.gunkin.repositories.WorkerRepository;
import ru.kpfu.itis.gunkin.services.WorkerService;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService{
    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public void createWorker(Worker worker) {
        workerRepository.saveAndFlush(worker);
    }

    @Override
    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public void updateWorker(Worker worker) {
        workerRepository.saveAndFlush(worker);
    }

    @Override
    public void removeWorker(int id) {
        workerRepository.delete(id);
    }

    @Override
    public Worker getWorkerById(int id) {
        return workerRepository.getWorkerById(id);
    }
}
