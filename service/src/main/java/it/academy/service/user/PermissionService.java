package it.academy.service.user;

import it.academy.dao.user.PermissionDao;
import it.academy.model.user.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Transactional
    public void addNewPermission(Permission permission) {
        permissionDao.createPermission(permission);
    }

    @Transactional
    public List listOfPermission(int pageNumber, int pageSize) {
        return permissionDao.findAllPermissionsNames(pageNumber, pageSize);
    }
}
