package it.academy.controller.user;

import it.academy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserListController {

    @Autowired
    UserService userService;

    private static final int PAGE_SIZE = 5;

    @GetMapping("/user-list/0.view")
    public ModelAndView showUserStartPage() {
        return new ModelAndView(
                "user_list",
                Map.of("users", userService.listOfUsers(0, PAGE_SIZE))
        );
    }

    @GetMapping("/user-list/${offset}.view")
    public ModelAndView showUserPaginationPage(@PathVariable int offset) {
        return new ModelAndView(
                "user_list",
                Map.of("users", userService.listOfUsers(offset, PAGE_SIZE))
        );
    }
}
