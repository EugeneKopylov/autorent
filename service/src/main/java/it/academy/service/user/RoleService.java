package it.academy.service.user;

import it.academy.dao.user.RoleDao;
import it.academy.model.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    @Transactional
    public void addNewRole(Role role) {
        roleDao.createRole(role);
    }

    @Transactional
    public List listOfRoleNames(int pageNumber, int pageSize) {
        return roleDao.findAllRoleNames(pageNumber, pageSize);
    }
}
