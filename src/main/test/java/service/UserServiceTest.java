package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.itis.gunkin.entities.School;
import ru.kpfu.itis.gunkin.entities.User;
import ru.kpfu.itis.gunkin.services.impl.UserService;
import util.SchoolUtil;
import util.UserUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    private User user;

    @Before
    public void createUser(){
        user = UserUtil.createUser();
        userService.addNew(user);
    }

    @Test
    public void serviceShouldCreateUser() {
        Assert.assertEquals(user, userService.getUserById(1));
    }

    @Test
    public void serviceShouldChangeInfo(){
        user.setUserId(1);
        user.setInfo("New info");
        user.setFirstName("Tim");
        user.setLastName("Cook");

        userService.addNew(user);
        User serviceUser = userService.getUserById(1);

        Assert.assertEquals("New info", serviceUser.getInfo());
        Assert.assertEquals("Tim", serviceUser.getFirstName());
        Assert.assertEquals("Cook", serviceUser.getLastName());
    }

    @Test
    public void serviceShouldAddschool(){
        School school = SchoolUtil.createSchools().get(1);
        user.setUserId(1);
        user.getSchools().add(school);
        userService.addNew(user);

        Assert.assertEquals(user.getSchools(), userService.getUserById(1).getSchools());
    }
}
