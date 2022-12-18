package it.academy.controller;

import it.academy.dao.PermissionDao;
import it.academy.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    private PermissionDao permissionDao;

    private static final int pageSize = 3;

    @RequestMapping(value = "/permission-list/0.html", method = RequestMethod.GET)
    public ModelAndView showPermissionList() {
//        pageable.getPrintable(2);
        return new ModelAndView(
                "permission_list",
                Map.of("permissions", permissionDao.findAllPermissionsNames(0, pageSize))
        );
    }
    @GetMapping("/permission-list/{offset}.html")
    private ModelAndView getProductsWithPagination(@PathVariable int offset) {
        System.out.println("is this pagination?");
        return new ModelAndView(
                "permission_list",
                Map.of("permissions", permissionDao.findAllPermissionsNames(offset, pageSize))
        );
    }
}