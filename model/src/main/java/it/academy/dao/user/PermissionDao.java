package it.academy.dao.user;

import it.academy.model.user.Permission;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {

    List findAllPermissionsNames(int pageNumber, int pageSize);

    Permission createPermission(Permission permission);

    Page<Permission> findPermissionWithPagination(int offset, int pageSize);

}
