package service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.itis.gunkin.repositories.CommentRepository;
import ru.kpfu.itis.gunkin.repositories.NewsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class CommentServiceTest {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CommentRepository commentRepository;
}