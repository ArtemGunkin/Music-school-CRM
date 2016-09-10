package util;

import ru.kpfu.itis.gunkin.entities.Worker;

import java.util.ArrayList;

public class WorkerUtil {

    public static ArrayList<Worker> createWorkers() {
        ArrayList<Worker> workers = new ArrayList<Worker>();

        Worker worker1 = new Worker(1, "Elvin", "Graham", "Some info about Elvin", "Guitar Master");
        Worker worker2 = new Worker(2, "Denver", "Derby", "Some info about Denver", "Piano Master");
        Worker worker3 = new Worker(3, "Davie", "Rufus", "Some info about Davie", "Balalaika Master");

        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);

        return workers;
    }
}
