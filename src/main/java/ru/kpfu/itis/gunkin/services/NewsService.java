package ru.kpfu.itis.gunkin.services;

import ru.kpfu.itis.gunkin.entities.News;

import java.util.List;

public interface NewsService {

    void createNews(News news);

    List<News> getNews();

    void removeNews(long id);

    News getItemById(long id);
}
