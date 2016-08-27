package ru.kpfu.itis.gunkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.gunkin.services.SchoolService;
import ru.kpfu.itis.gunkin.services.WorkerService;
import ru.kpfu.itis.gunkin.services.impl.UserService;

@Controller
@RequestMapping("/update")
public class UpdateController {
    @Autowired
    UserService userService;
    @Autowired
    WorkerService workerService;
    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "/worker/{id}", method = RequestMethod.GET)
    public String updateWorker(ModelMap model, @PathVariable("id") int id) {
        model.put("worker", workerService.getWorkerById(id));
        return "update/worker";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String updateUser(ModelMap model, @PathVariable("id") int id) {
        model.put("user", userService.getUserById(id));
        return "update/user";
    }

    @RequestMapping(value = "/school/{id}", method = RequestMethod.GET)
    public String updateSchool(ModelMap model, @PathVariable("id") int id) {
        model.put("school", schoolService.getSchoolById(id));
        model.put("workers", workerService.getWorkers());
        return "update/school";
    }
}
