package it.academy.dao;

import it.academy.model.Role;
import it.academy.repository.RoleRepository;
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
}
