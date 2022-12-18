package it.academy.service;

import it.academy.dao.PermissionDao;
import it.academy.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Transactional
    public void addNewPermission(Permission permission) {
        permissionDao.createPermission(permission);
    }
}
