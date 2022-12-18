package it.academy.dao;

import it.academy.model.Permission;
import it.academy.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PermissionDaoImpl implements PermissionDao {

    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public List findAllPermissionsNames(int pageNumber, int pageSize) {
        return permissionRepository.findAll(PageRequest.of(pageNumber,pageSize)).getContent();
    }

    @Override
    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Page<Permission> findPermissionWithPagination(int offset, int pageSize) {
        return permissionRepository.findAll(PageRequest.of(offset, pageSize));
    }
}
