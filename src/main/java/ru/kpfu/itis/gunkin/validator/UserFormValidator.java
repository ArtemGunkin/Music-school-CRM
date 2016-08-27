package ru.kpfu.itis.gunkin.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.itis.gunkin.entities.User;
import ru.kpfu.itis.gunkin.services.impl.UserService;

@Component
public class UserFormValidator implements Validator {
    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.userForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.userForm.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "info", "NotEmpty.userForm.info");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");

        if (user.getFirstName().equalsIgnoreCase("none")) {
            errors.rejectValue("firstName", "NotEmpty.userForm.firstName");
        }

        if (user.getLastName().equalsIgnoreCase("none")) {
            errors.rejectValue("lastName", "NotEmpty.userForm.lastName");
        }

        if (user.getPhone() == null || user.getPhone() <= 0) {
            errors.rejectValue("number", "NotEmpty.userForm.number");
        }
    }
}
