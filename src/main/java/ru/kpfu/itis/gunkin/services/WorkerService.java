package ru.kpfu.itis.gunkin.services;

import ru.kpfu.itis.gunkin.entities.Worker;

import java.util.List;

public interface WorkerService {

    void createWorker(Worker worker);

    List<Worker> getWorkers();

    void updateWorker(Worker worker);

    void removeWorker(int id);

    Worker getWorkerById(int id);

}
