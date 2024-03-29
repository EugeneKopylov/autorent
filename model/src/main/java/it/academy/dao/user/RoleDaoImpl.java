package it.academy.dao.user;

import it.academy.model.user.Role;
import it.academy.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    RoleRepository roleRepository;


    @Override
    public List findAllRoleNames(int pageNumber, int pageSize) {
        return roleRepository.findAll(PageRequest.of(pageNumber,pageSize)).getContent();
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findRoleById(int roleId) {
        return roleRepository.findById(roleId).isPresent() ? roleRepository.findById(roleId).get() : null;
    }

    @Override
    public Role findRoleByName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
