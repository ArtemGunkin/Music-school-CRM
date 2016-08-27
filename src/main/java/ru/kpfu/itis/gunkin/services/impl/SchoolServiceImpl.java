package ru.kpfu.itis.gunkin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.gunkin.entities.School;
import ru.kpfu.itis.gunkin.entities.User;
import ru.kpfu.itis.gunkin.repositories.SchoolRepository;
import ru.kpfu.itis.gunkin.services.SchoolService;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService{
    @Autowired
    private SchoolRepository schoolRepository;


    @Override
    public void createSchool(School school) {
        schoolRepository.saveAndFlush(school);
    }

    @Override
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public void updateSchool(School school) {
        schoolRepository.saveAndFlush(school);
    }

    @Override
    public School getSchoolById(int id) {
        return schoolRepository.getSchoolById(id);
    }

    @Override
    public void removeSchool(int id) {
        schoolRepository.delete(id);
    }

    @Override
    public List<School> getUserSchools(User user) {
        return schoolRepository.findAllByUsers(user);
    }
}
