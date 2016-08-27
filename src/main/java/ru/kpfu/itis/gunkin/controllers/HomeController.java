package ru.kpfu.itis.gunkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.gunkin.entities.*;
import ru.kpfu.itis.gunkin.services.CommentService;
import ru.kpfu.itis.gunkin.services.SchoolService;
import ru.kpfu.itis.gunkin.services.WorkerService;
import ru.kpfu.itis.gunkin.services.impl.NewsServiceImpl;
import ru.kpfu.itis.gunkin.services.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private NewsServiceImpl newsService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(method = RequestMethod.GET)
    public String indexPage() {
        return "home/index";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String aboutPage(ModelMap modelMap) {
        modelMap.put("workers", workerService.getWorkers());
        return "home/about";
    }

    @RequestMapping(value = "/schools", method = RequestMethod.GET)
    public String schoolsPage(ModelMap model) {
        model.put("schools", schoolService.getSchools());
        return "home/schools";
    }

    @RequestMapping(value = "/schools/{id}", method = RequestMethod.GET)
    public String schoolPage(ModelMap model, @PathVariable("id") int id) {
        School school = schoolService.getSchoolById(id);
        model.put("school", school);
        return "home/school";
    }

    @RequestMapping(value = "/schools/{id}/buy", method = RequestMethod.POST)
    public String schoolsBuy(HttpServletRequest request, @PathVariable("id") int id) {
        int userId = userService.getId(request.getRemoteUser());
        School school = schoolService.getSchoolById(id);
        User user = userService.getUserById(userId);

        school.getUsers().add(user);
        schoolService.updateSchool(school);
        return "redirect:/user";
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String newsPage(ModelMap model) {
        model.put("news", newsService.getNews());
        return "home/news";
    }

    @RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
    public String itemPage(ModelMap model, @PathVariable("id") long id) {
        List<Comment> comments = commentService.getNewsComments(id);
        News item = newsService.getItemById(id);
        model.put("comments", comments);
        model.put("item", item);
        return "home/item";
    }

    @RequestMapping(value = "/news/{id}/comment", method = RequestMethod.POST)
    public String createComment(HttpServletRequest request, @PathVariable("id") int id, @RequestParam String content) {
        int userId = userService.getId(request.getRemoteUser());
        News news = newsService.getItemById(id);
        User user = userService.getUserById(userId);
        Comment comment = new Comment(content, user, news, new Date());
        commentService.createComment(comment);
        return "redirect:/news/" + id;
    }
}