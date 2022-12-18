package it.academy.controller;

import it.academy.model.Permission;
import it.academy.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddPermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/add-permission.html")
    public String showAddProductPage() {
        return "add_permission";
    }

    @PostMapping("/add-permission.html")
    public String addPermission(Permission permission) {
        System.out.println("AddPermission " + permission);
        permissionService.addNewPermission((Permission) permission);
        return "redirect:/permission-list/0.html";
    }
}