package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.itis.gunkin.entities.Comment;
import ru.kpfu.itis.gunkin.entities.News;
import ru.kpfu.itis.gunkin.entities.User;
import ru.kpfu.itis.gunkin.repositories.CommentRepository;
import ru.kpfu.itis.gunkin.repositories.NewsRepository;
import ru.kpfu.itis.gunkin.services.CommentService;
import ru.kpfu.itis.gunkin.services.NewsService;
import ru.kpfu.itis.gunkin.services.impl.UserService;
import util.CommentUtil;
import util.NewsUtil;
import util.UserUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private UserService userService;

    private Comment comment;

    @Before
    public void createComment(){
        News news = NewsUtil.createNews().get(1);
        User user = UserUtil.createUser();

        newsService.createNews(news);
        userService.addNew(user);
        comment = CommentUtil.createComment(news, user);
    }

    @Test
    public void serviceShouldAddComment(){
        commentService.createComment(comment);
        Assert.assertEquals(1, commentService.getNewsComments(1).size());
    }
}