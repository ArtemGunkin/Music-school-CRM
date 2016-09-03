package ru.kpfu.itis.gunkin.controllers;

import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.gunkin.entities.News;
import ru.kpfu.itis.gunkin.entities.School;
import ru.kpfu.itis.gunkin.entities.User;
import ru.kpfu.itis.gunkin.entities.Worker;
import ru.kpfu.itis.gunkin.json.Views;
import ru.kpfu.itis.gunkin.services.NewsService;
import ru.kpfu.itis.gunkin.services.SchoolService;
import ru.kpfu.itis.gunkin.services.WorkerService;
import ru.kpfu.itis.gunkin.services.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    SchoolService schoolService;
    @Autowired
    NewsService newsService;
    @Autowired
    WorkerService workerService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/schools", method = RequestMethod.GET)
    public ResponseEntity<List<School>> getSchools() {
        List<School> schools = schoolService.getSchools();
        return new ResponseEntity<List<School>>(schools, HttpStatus.OK);
    }

    @RequestMapping(value = "/schools/{id}", method = RequestMethod.GET)
    public ResponseEntity<School> getSchool(@PathVariable("id") int id) {
        School school = schoolService.getSchoolById(id);
        return new ResponseEntity<School>(school, HttpStatus.OK);
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public ResponseEntity<List<News>> getNews() {
        List<News> news = newsService.getNews();
        return new ResponseEntity<List<News>>(news, HttpStatus.OK);
    }

    @RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
    public ResponseEntity<News> getNewsItem(@PathVariable("id") int id) {
        News news = newsService.getItemById(id);
        return new ResponseEntity<News>(news, HttpStatus.OK);
    }

    @RequestMapping(value = "/workers", method = RequestMethod.GET)
    public ResponseEntity<List<Worker>> getWorkers() {
        List<Worker> worker = workerService.getWorkers();
        return new ResponseEntity<List<Worker>>(worker, HttpStatus.OK);
    }

    @RequestMapping(value = "/workers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Worker> getWorker(@PathVariable("id") int id) {
        Worker worker = workerService.getWorkerById(id);
        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<List<School>> profile(HttpServletRequest request) {
        int id = userService.getId(request.getRemoteUser());
        User user = userService.getUserById(id);
        List<School> schools = schoolService.getUserSchools(user);
        return new ResponseEntity<List<School>>(schools, HttpStatus.OK);
    }

    @RequestMapping(value = "/schools/{id}/add", method = RequestMethod.POST)
    public ResponseEntity<List<School>> addSchool(HttpServletRequest request, @PathVariable("id") int id) {
        int userId = userService.getId(request.getRemoteUser());
        User user = userService.getUserById(userId);
        School school = schoolService.getSchoolById(id);
        school.getUsers().add(user);
        schoolService.updateSchool(school);
        List<School> schools = schoolService.getUserSchools(user);
        return new ResponseEntity<List<School>>(schools, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/users/search")
    public ResponseEntity<List<User>> getUsers(@RequestBody String query) {
        ArrayList<User> users = (ArrayList<User>) userService.findByFirstName(query);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
