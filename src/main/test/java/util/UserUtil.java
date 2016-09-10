package util;

import org.junit.Test;
import ru.kpfu.itis.gunkin.entities.User;

public class UserUtil {
    public static User createUser(){
        User user = new User("artyom", "artyom", "Artyom", "Gunkin", 12345, "Some info");
        return user;
    }

}
