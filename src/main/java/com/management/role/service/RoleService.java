package com.management.role.service;

import com.management.role.model.RoleModel;
import com.management.role.repository.RoleRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * This class is a service for role
 */
@Singleton
public class RoleService {

    @Inject
    private RoleRepository roleRepository;

    /**
     * This method is used for saving a role
     */
    public RoleModel saveRole(RoleModel roleModel) {
        return roleRepository.save(roleModel);
    }

    /**
     * This method is used for fetching all roles
     */
    public List<RoleModel> getRole() {
        return roleRepository.findAll();
    }

    /**
     * This method is used for updating a role
     */
    public RoleModel updateRole(String id, RoleModel roleModel) {
        roleModel.setRoleId(id);
        roleRepository.update(roleModel);
        return roleModel;
    }

    /**
     * This method is used for deleting a role
     */
    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }
}
