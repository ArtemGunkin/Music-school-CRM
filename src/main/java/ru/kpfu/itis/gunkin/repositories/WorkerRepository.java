package ru.kpfu.itis.gunkin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.gunkin.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    Worker getWorkerById(int id);
}
