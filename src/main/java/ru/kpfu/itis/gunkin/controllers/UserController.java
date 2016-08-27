package ru.kpfu.itis.gunkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.gunkin.entities.User;
import ru.kpfu.itis.gunkin.services.SchoolService;
import ru.kpfu.itis.gunkin.services.impl.CommentServiceImpl;
import ru.kpfu.itis.gunkin.services.impl.NewsServiceImpl;
import ru.kpfu.itis.gunkin.services.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(method = RequestMethod.GET)
    public String profile(ModelMap model, HttpServletRequest request) {
        int id = userService.getId(request.getRemoteUser());
        User user = userService.getUserById(id);
        model.put("user", user);
        model.put("schools", schoolService.getUserSchools(user));
        return "user/profile";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(ModelMap model, HttpServletRequest request) {
        int id = userService.getId(request.getRemoteUser());
        User user = userService.getUserById(id);
        model.put("user", user);
        return "update/user";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(HttpServletRequest request, @ModelAttribute("userForm") User user) {
        int id = userService.getId(request.getRemoteUser());
        User oldUser = userService.getUserById(id);

        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setInfo(user.getInfo());
        oldUser.setInfo(user.getInfo());
        oldUser.setPhone(user.getPhone());

        userService.addNew(oldUser);
        return "redirect:/admin/users";
    }

}