package ru.kpfu.itis.gunkin.services;

import ru.kpfu.itis.gunkin.entities.School;
import ru.kpfu.itis.gunkin.entities.User;

import java.util.List;

public interface SchoolService {

    void createSchool(School school);

    List<School> getSchools();

    void updateSchool(School school);

    School getSchoolById(int id);

    void removeSchool(int id);

    List<School> getUserSchools(User user);
}
