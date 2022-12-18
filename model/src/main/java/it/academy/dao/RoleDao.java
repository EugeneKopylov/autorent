package it.academy.dao;

import it.academy.model.Permission;
import it.academy.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    List findAllRoleNames(int pageNumber, int pageSize);

    Role createRole(Role role);


}
