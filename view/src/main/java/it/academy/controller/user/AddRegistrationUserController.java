package it.academy.controller.user;

import it.academy.model.user.ApplicationUser;
import it.academy.model.user.User;
import it.academy.model.user.UserInformation;
import it.academy.service.user.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddRegistrationUserController {

    @Autowired
    UserService userService;

    @GetMapping("registration.view")
    public String addRegistrationUser() {
        return "registration";
    }

    @PostMapping("add-reg-user.action")
    @SneakyThrows
    public String addRegistrationUser(UserInformation userInformation, ApplicationUser applicationUser, User user){
        userService.addCustomerUser(userInformation,applicationUser,user);
        return "redirect:/";
    }


}
