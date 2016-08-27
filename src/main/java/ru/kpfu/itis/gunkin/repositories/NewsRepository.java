package ru.kpfu.itis.gunkin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.gunkin.entities.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    News getNewsById(long id);
}
