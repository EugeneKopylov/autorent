package it.academy.controller.user;

import it.academy.model.user.User;
import it.academy.model.user.UserInformation;
import it.academy.service.user.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddUserInformationController {

    @Autowired
    UserService userService;

    @GetMapping("/add-user-information.view")
    public String getMapping() {
        return "add_user_information";
    }

    @PostMapping("add-user-information.action")
    @SneakyThrows
    public String addUserInformation(User user, UserInformation userInformation){
        userService.addNewUserInformation(userInformation);
        return "redirect:/user-list/0.view";
    }
}
