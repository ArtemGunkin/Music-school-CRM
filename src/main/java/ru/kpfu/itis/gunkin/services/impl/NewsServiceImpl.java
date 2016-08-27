package ru.kpfu.itis.gunkin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.gunkin.entities.News;
import ru.kpfu.itis.gunkin.repositories.NewsRepository;
import ru.kpfu.itis.gunkin.services.NewsService;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void createNews(News news) {
        newsRepository.saveAndFlush(news);
    }

    @Override
    public List<News> getNews() {
        return newsRepository.findAll();
    }

    @Override
    public void removeNews(long id) {
        newsRepository.delete(id);
    }

    @Override
    public News getItemById(long id) {
        return newsRepository.getNewsById(id);
    }
}
