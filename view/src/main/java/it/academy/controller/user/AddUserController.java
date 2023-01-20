package it.academy.controller.user;

import it.academy.model.user.ApplicationUser;
import it.academy.service.user.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AddUserController {

    @Autowired
    UserService userService;

    @GetMapping("/add-user.view")
    public ModelAndView addUserPage(){
        return new ModelAndView("add_user", Map.of("roleName", userService.getAllRoleNames()));
    }

    @PostMapping("add-user.action")
    @SneakyThrows
    public String addUser(ApplicationUser applicationUser, @RequestParam String roleName){

        userService.createUserWithApplicationUserInfo(applicationUser, roleName);
        return "redirect:/user-list/0.view";
    }
}
