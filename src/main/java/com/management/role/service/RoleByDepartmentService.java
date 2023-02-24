package com.management.role.service;

import com.management.role.model.RoleByDepartmentModel;
import com.management.role.repository.RoleByDepartmentRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * This class is a service for role by department
 */
@Singleton
public class RoleByDepartmentService {

    @Inject
    private RoleByDepartmentRepository roleByDepartmentRepository;

    /**
     * This method is used for saving a role by department
     */
    public RoleByDepartmentModel saveRoleByDepartment(RoleByDepartmentModel roleByDepartmentModel) {
        return roleByDepartmentRepository.save(roleByDepartmentModel);
    }

    /**
     * This method is used for fetching all role by departments
     */
    public List<RoleByDepartmentModel> getRoleByDepartment() {
        return roleByDepartmentRepository.findAll();
    }
}
