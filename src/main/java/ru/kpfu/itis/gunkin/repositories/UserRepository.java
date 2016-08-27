package ru.kpfu.itis.gunkin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.gunkin.entities.School;
import ru.kpfu.itis.gunkin.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(int id);

    User findByLogin(String login);

    @Query("select userRole from User u where u.login = :login")
    String getUserRoleByLogin(@Param("login") String login);

    @Query("select userId from User u where u.login = :login")
    int getUserIdByLogin(@Param("login") String login);

    List<User> findByUserRole(String role);

    List<User> findAllBySchools(School school);
}