package it.academy.controller.user;

import it.academy.model.user.Permission;
import it.academy.service.user.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddPermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/add-permission.view")
    public String showAddProductPage() {
        return "add_permission";
    }

    @PostMapping("/add-permission.action")
    public String addPermission(Permission permission) {
        System.out.println("AddPermission " + permission);
        permissionService.addNewPermission(permission);
        return "redirect:/permission-list/0.view";
    }
}