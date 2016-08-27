package ru.kpfu.itis.gunkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.gunkin.entities.School;
import ru.kpfu.itis.gunkin.entities.User;
import ru.kpfu.itis.gunkin.services.impl.UserService;
import ru.kpfu.itis.gunkin.validator.UserFormValidator;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    UserService userService;

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(userFormValidator);
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String showPage() {
        return "user/registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addNew(ModelMap model, @ModelAttribute("userForm") @Validated User user) {
        userService.addNew(user);
        model.put("msg", "Please sign in after registration.");
        return "redirect:/login";
    }
}
