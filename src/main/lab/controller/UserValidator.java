package main.lab.controller;

import main.lab.model.Users;
import main.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserValidator {

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public String validate(Object o) {
        Users user = (Users) o;

        if (user.getUsername() == null)
            return "Invalid username";
        else {
            if (user.getUsername().length() < 3 || user.getUsername().length() > 10) {
                return "Invalid size username";
            }

            if (userService.findByUsername(user.getUsername()) != null) {
                return "Duplicate username";
            }

            if (!checkValidChars(user.getUsername()))
                return "Invalid username";
        }

        if (user.getPassword() == null) {
            return  "Invalid password";
        } else {
            if (user.getPassword().length() < 5 || user.getPassword().length() > 10) {
                return "Invalid size password";
            }

            if (!checkValidChars(user.getPassword()))
                return "Invalid password";
        }

        return "success";
    }

    private boolean checkValidChars(String login) {
        return login.chars().allMatch(c ->
                (c >= '0' && c <= '9') ||
                        (c >= 'a' && c <= 'z') ||
                        (c >= 'A' && c <= 'Z') ||
                        c == '_'
        );
    }

}