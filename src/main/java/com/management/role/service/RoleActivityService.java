package com.management.role.service;

import com.management.role.model.RoleActivityModel;
import com.management.role.repository.RoleActivityRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * This class is a service for role activity
 */
@Singleton
public class RoleActivityService {

    @Inject
    private RoleActivityRepository roleActivityRepository;

    /**
     * This method is used for saving a role activity
     */
    public RoleActivityModel saveRoleActivity(RoleActivityModel roleActivityModel) {
        return roleActivityRepository.save(roleActivityModel);
    }

    /**
     * This method is used for fetching all role activities
     */
    public List<RoleActivityModel> getRoleActivity() {
        return roleActivityRepository.findAll();
    }
}