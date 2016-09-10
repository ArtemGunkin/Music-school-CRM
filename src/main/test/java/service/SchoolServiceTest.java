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
import util.SchoolUtil;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class SchoolServiceTest {
    @Autowired
    private SchoolService schoolService;
    private ArrayList<School> schools;

    @Before
    public void createSchools() {
        schools = SchoolUtil.createSchools();
        for (School school : schools)
            schoolService.createSchool(school);
    }

    @Test
    public void serviceShouldReturnSchools() {
        Assert.assertEquals(schools, schoolService.getSchools());
    }

    @Test
    public void serviceShouldReturnActiveSchools() {
        Assert.assertEquals(SchoolUtil.returnActive(schools), schoolService.getActiveSchools());
    }

    @Test
    public void serviceShouldDisableSchool() {
        for (School school : SchoolUtil.returnActive(schools))
            schoolService.disableSchoolById(school.getId());

        Assert.assertEquals(0, schoolService.getActiveSchools().size());
    }

    @Test
    public void serviceShouldEnableSchool() {
        for (School school : schoolService.getSchools())
            schoolService.enableSchoolById(school.getId());

        Assert.assertEquals(schoolService.getSchools(), schoolService.getActiveSchools());
    }
}
