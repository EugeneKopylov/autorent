package it.academy.dao.user;

import it.academy.model.user.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    List findAllRoleNames(int pageNumber, int pageSize);

    Role createRole(Role role);

    Role findRoleById(int roleId);

    public Role findRoleByName(String roleName);

    List<Role> findAllRoles();
}
