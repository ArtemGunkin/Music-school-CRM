package util;

import ru.kpfu.itis.gunkin.entities.News;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsUtil {
    public static List<News> createNews(){
        ArrayList<News> news = new ArrayList<News>();

        News news1 = new News("First title", "First Content", new Date());
        News news2 = new News("Second title", "Second Content", new Date());
        News news3 = new News("Third title", "Third Content", new Date());

        news.add(news1);
        news.add(news2);
        news.add(news3);

        return news;
    }
}
