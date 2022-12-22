package it.academy.controller;

import it.academy.model.User;
import it.academy.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddUserController {

    @Autowired
    UserService userService;

    @GetMapping("/add-user.view")
    public String getMapping() {
        return "add_user";
    }

    @PostMapping("/add-user.action")
    @SneakyThrows
    public String addUser(User user) {
        userService.addNewUser(user);
        return "redirect:/user-list/0.view";
    }
}
