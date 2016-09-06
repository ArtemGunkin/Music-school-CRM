package service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.itis.gunkin.repositories.NewsRepository;
import ru.kpfu.itis.gunkin.services.NewsService;
import ru.kpfu.itis.gunkin.services.impl.NewsServiceImpl;

import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class NewsServiceTest {
    @Autowired
    private NewsRepository newsRepository;
}
