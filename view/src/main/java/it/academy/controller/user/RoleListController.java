package it.academy.controller.user;

import it.academy.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class RoleListController {

    @Autowired
    RoleService roleService;

    private static final int pageSize = 3;

    @RequestMapping(value = "/role-list/0.view", method = RequestMethod.GET)
    public ModelAndView showRoleList() {
        return new ModelAndView(
                "role_list",
                Map.of("roles", roleService.listOfRoleNames(0, pageSize))
        );
    }
    @GetMapping("/role-list/{offset}.view")
    private ModelAndView getProductsWithPagination(@PathVariable int offset) {
        return new ModelAndView(
                "role_list",
                Map.of("roles", roleService.listOfRoleNames(offset, pageSize))
        );
    }
}
