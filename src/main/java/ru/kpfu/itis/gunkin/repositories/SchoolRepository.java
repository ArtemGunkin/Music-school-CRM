package ru.kpfu.itis.gunkin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.gunkin.entities.School;
import ru.kpfu.itis.gunkin.entities.User;
import ru.kpfu.itis.gunkin.entities.Worker;

import java.util.List;

import static java.awt.SystemColor.info;

public interface SchoolRepository extends JpaRepository<School, Integer> {
    School getSchoolById(int id);

    List<School> findAllByUsers(User user);

    @Modifying
    @Query("update School c set c.name = :name, c.cost = :cost, c.info = :info, c.worker = :worker where c.id = :id")
    Integer updateSchoolInfo(@Param("id") Integer id, @Param("name") String name, @Param("info") String info, @Param("worker") Worker worker);
}
