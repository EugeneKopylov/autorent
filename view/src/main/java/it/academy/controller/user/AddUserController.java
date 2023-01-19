package it.academy.controller.user;

import it.academy.model.user.User;
import it.academy.model.user.UserInformation;
import it.academy.service.user.UserInformationService;
import it.academy.service.user.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddUserController {

    @Autowired
    UserService userService;

    @GetMapping("/add-user.view")
    public String getMapping() {
        return "add_user";
    }

    @PostMapping("add-user.action")
    @SneakyThrows
    public String addUser(User user, UserInformation userInformation){
        userService.addNewUser(userInformation);
        return "redirect:/user-list/0.view";
    }
}
