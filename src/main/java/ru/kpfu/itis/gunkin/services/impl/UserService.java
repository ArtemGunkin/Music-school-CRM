package ru.kpfu.itis.gunkin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.gunkin.entities.School;
import ru.kpfu.itis.gunkin.entities.User;
import ru.kpfu.itis.gunkin.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int id){
        return userRepository.findByUserId(id);
    }

    public User getUserByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public int getId(String login){
        return userRepository.getUserIdByLogin(login);
    }

    public String getRole(String login){
        return userRepository.getUserRoleByLogin(login);
    }

    public List<User> getUserByUserRole(String s) {
        return userRepository.findByUserRole(s);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> findAllUsersBySchools(School school) {
        return userRepository.findAllBySchools(school);
    }

    @Transactional
    public User addNew(User user) {
        return userRepository.saveAndFlush(user);
    }
}
