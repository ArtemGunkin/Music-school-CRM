package util;

import ru.kpfu.itis.gunkin.entities.School;
import ru.kpfu.itis.gunkin.entities.Worker;

import java.util.ArrayList;
import java.util.List;

public class SchoolUtil {
    public static ArrayList<School> createSchools(){
        ArrayList<Worker> workers = WorkerUtil.createWorkers();
        ArrayList<School> schools = new ArrayList<School>();

        School guitarSchool = new School(1, 550, "Guitar school", "Some info about piano school", workers.get(0));
        School pianoSchool = new School(2, 700, "Piano school", "Some info about piano school", workers.get(1));
        School balalaikaSchool = new School(3, 630, "Balalaika school", "Some info about balalaika school", workers.get(2));

        balalaikaSchool.setEnable(false);

        schools.add(guitarSchool);
        schools.add(pianoSchool);
        schools.add(balalaikaSchool);

        return schools;
    }

    public static List<School> returnActive(List<School> schools){
        ArrayList<School> activeSchools = new ArrayList<School>();
        for (School school : schools)
            if (school.getEnable())
                activeSchools.add(school);

        return activeSchools;
    }
}
