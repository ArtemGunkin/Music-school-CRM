package ru.kpfu.itis.gunkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.gunkin.entities.News;
import ru.kpfu.itis.gunkin.entities.School;
import ru.kpfu.itis.gunkin.entities.User;
import ru.kpfu.itis.gunkin.entities.Worker;
import ru.kpfu.itis.gunkin.services.NewsService;
import ru.kpfu.itis.gunkin.services.SchoolService;
import ru.kpfu.itis.gunkin.services.WorkerService;
import ru.kpfu.itis.gunkin.services.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    NewsService newsService;
    @Autowired
    WorkerService workerService;
    @Autowired
    SchoolService schoolService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model, @RequestParam(value = "type", required = false) String view) {
        int activeUsers = 0;
        int schoolsSale = 0;
        int income = 0;

        HashMap<String, Integer> schoolMap = new HashMap<String, Integer>();
        ArrayList<User> users = (ArrayList<User>) userService.getUsers();
        for (User user : users) {
            if (user.getSchools().size() > 0) {
                activeUsers++;
                schoolsSale += user.getSchools().size();
            }

            for (School school: user.getSchools())
                income += school.getCost();
        }

        for (School school : schoolService.getSchools())
            schoolMap.put(school.getName(), userService.findAllUsersBySchools(school).size());

        model.addObject("active_users", activeUsers);
        model.addObject("all_users", users.size());
        model.addObject("schools_sale", schoolsSale);
        model.addObject("income", income);
        model.addObject("schools", schoolMap);

        if (view != null && view.equals("pdf"))
            model.setViewName("pdfView");
        else
            model.setViewName("admin/index");
        return model;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap model) {
        model.put("users", userService.getUsers());
        return "admin/users";
    }

    @RequestMapping(value = "/schools", method = RequestMethod.GET)
    public String schools(ModelMap model) {
        model.put("schools", schoolService.getSchools());
        model.put("workers", workerService.getWorkers());
        return "admin/schools";
    }

    @RequestMapping(value = "/schools/add", method = RequestMethod.POST)
    public String addSchool(@ModelAttribute("schoolForm") School school, @RequestParam int workerId) {
        Worker worker = workerService.getWorkerById(workerId);
        school.setWorker(worker);

        School oldSchool = schoolService.getSchoolById(school.getId());
        if (oldSchool != null)
            school.setUsers(oldSchool.getUsers());

        schoolService.createSchool(school);
        return "redirect:/admin/schools";
    }

    @RequestMapping(value = "/workers", method = RequestMethod.GET)
    public String workers(ModelMap model) {
        model.put("workers", workerService.getWorkers());
        return "admin/workers";
    }

    @RequestMapping(value = "/workers/new", method = RequestMethod.POST)
    public String addWorker(@ModelAttribute("workerForm") Worker worker) {
        System.out.println(worker);
        workerService.createWorker(worker);
        return "redirect:/admin/workers";
    }

    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public String content(ModelMap model) {
        model.put("news", newsService.getNews());
        return "admin/content";
    }

    @RequestMapping(value = "/content/new", method = RequestMethod.POST)
    public String addContent(@RequestParam String title, @RequestParam String content) {
        News news = new News(title, content, new Date());
        newsService.createNews(news);
        return "redirect:/admin/content";
    }

    @RequestMapping(value = "/content/remove/{id}", method = RequestMethod.POST)
    public String removeContent(@PathVariable("id") int id) {
        newsService.removeNews(id);
        return "redirect:/admin/content";
    }
}