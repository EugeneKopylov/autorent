package it.academy.controller.user;

import it.academy.model.user.User;
import it.academy.service.user.ApplicationUserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Secured(value = {"ROLE_USER"})
@Controller
public class UpdateUserInformation {

    @Autowired
    ApplicationUserService applicationUserService;

    @GetMapping("/update-user-information.view")
    public ModelAndView updateUserInformationPage(){
        User user = applicationUserService.findApplicationUserByNickName(
                SecurityContextHolder.getContext().getAuthentication().getName()).getUser();
        return new ModelAndView("update_user_information",
                Map.of("nickname", (user.getApplicationUser().getNickname() == null) ? "is not set" : user.getApplicationUser().getNickname(),
                "firstName", (user.getUserInformation().getFirstName() == null) ? "is not set" : user.getUserInformation().getFirstName(),
                "lastName", (user.getUserInformation().getLastName() == null) ? "is not set" : user.getUserInformation().getLastName(),
                "phoneNumber", (user.getUserInformation().getPhoneNumber() == null) ? "is not set" : user.getUserInformation().getPhoneNumber(),
                "email", (user.getUserInformation().getEmail() == null) ? "is not set" : user.getUserInformation().getEmail()
                )
        );
    }

    @PostMapping("upreg-user.action")
    @SneakyThrows
    public String updateUserInformationAction(@RequestParam String nickname,
                                              @RequestParam String firstName,
                                              @RequestParam String lastName,
                                              @RequestParam String phoneNumber,
                                              @RequestParam String email) {
        String oldName = SecurityContextHolder.getContext().getAuthentication().getName();
        applicationUserService.updateUserInformation(oldName, nickname, firstName, lastName, phoneNumber, email);
        return "redirect:/";
    }

}
