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
import ru.kpfu.itis.gunkin.services.CommentService;
import ru.kpfu.itis.gunkin.services.NewsService;
import util.CommentUtil;
import util.NewsUtil;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class NewsServiceTest {
    @Autowired
    private NewsService newsService;

    private List<News> news;

    @Before
    public void createNews() {
        news = NewsUtil.createNews();
        for (News newsItem : news)
            newsService.createNews(newsItem);
    }

    @Test
    public void serviceShouldReturnNews() {
        Assert.assertEquals(news, newsService.getNews());
    }

    @Test
    public void serviceShouldEditNews(){
        News oldNews = newsService.getItemById(1);
        oldNews.setTitle("Fresh title");
        oldNews.setContent("Fresh content");
        newsService.createNews(oldNews);

        Assert.assertEquals("Fresh title", newsService.getItemById(1).getTitle());
        Assert.assertEquals("Fresh content", newsService.getItemById(1).getContent());
    }
}
