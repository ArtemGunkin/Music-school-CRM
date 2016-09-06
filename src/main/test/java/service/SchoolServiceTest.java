package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.itis.gunkin.entities.School;
import ru.kpfu.itis.gunkin.services.SchoolService;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class SchoolServiceTest {
    @Autowired
    private SchoolService schoolService;
    private ArrayList<School> schools;

    @Before
    public void createSchools(){
        schools  = new ArrayList<School>();
        School guitarSchool = new School(1, 550, "Guitar school", "Some info about piano school");
        School pianoSchool = new School(2, 700, "Piano school", "Some info about piano school");
        schools.add(guitarSchool);
        schools.add(pianoSchool);
    }

    @Test
    public void serviceShouldReturnSchools(){
        for (School school : schools)
            schoolService.createSchool(school);

        Assert.assertEquals(schools, schoolService.getSchools());
    }
}
