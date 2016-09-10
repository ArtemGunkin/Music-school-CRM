package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.itis.gunkin.entities.Worker;
import ru.kpfu.itis.gunkin.services.WorkerService;
import util.WorkerUtil;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class WorkerServiceTest {
    @Autowired
    private WorkerService workerService;

    private ArrayList<Worker> workers;

    @Before
    public void createSchools() {
        workers = WorkerUtil.createWorkers();
        for (Worker worker : workers)
            workerService.createWorker(worker);
    }

    @Test
    public void serviceShouldReturnWorkers() {
        Assert.assertEquals(workers, workerService.getWorkers());
    }

    @Test
    public void serviceShouldChangeInfo() {
        Worker worker = workerService.getWorkerById(1);
        worker.setFirstName("Artyom");
        worker.setLastName("Gunkin");
        worker.setInfo("Some info about Artyom");
        worker.setJobTitle("Do nothing master");

        workerService.updateWorker(worker);

        Assert.assertEquals("Artyom", workerService.getWorkerById(1).getFirstName());
        Assert.assertEquals("Gunkin", workerService.getWorkerById(1).getLastName());
        Assert.assertEquals("Some info about Artyom", workerService.getWorkerById(1).getInfo());
        Assert.assertEquals("Do nothing master", workerService.getWorkerById(1).getJobTitle());
    }
}
