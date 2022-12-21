package it.academy.controller;

import it.academy.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PermissionListController {

    @Autowired
    private PermissionService permissionService;

    private static final int pageSize = 3;

    @RequestMapping(value = "/permission-list/0.view", method = RequestMethod.GET)
    public ModelAndView showPermissionList() {
        return new ModelAndView(
                "permission_list",
                Map.of("permissions", permissionService.listOfPermission(0, pageSize))
        );
    }
    @GetMapping("/permission-list/{offset}.view")
    public ModelAndView getProductsWithPagination(@PathVariable int offset) {
        System.out.println("is this pagination?");
        return new ModelAndView(
                "permission_list",
                Map.of("permissions", permissionService.listOfPermission(offset, pageSize))
        );
    }
}