package it.academy.controller;

import it.academy.model.Role;
import it.academy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddRoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("add-role.view")
    public String showAddRolePage() {
        return "add_role";
    }

    @PostMapping("add-role.action")
    public String addRole(Role role) {
        roleService.addNewRole(role);
        return "redirect:/role-list/0.view";
    }
}
