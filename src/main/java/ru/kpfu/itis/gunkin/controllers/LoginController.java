package ru.kpfu.itis.gunkin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model, @RequestParam(required = false) String msg, HttpSession session) {
        session.setAttribute("user", "user");
        model.put("msg", msg);
        return "user/login";
    }

    @RequestMapping(value = "/login_error", method = RequestMethod.GET)
    public String loginFailure(ModelMap model) {
        model.put("msg", "Invalid login or password.");
        return "user/login";
    }
}