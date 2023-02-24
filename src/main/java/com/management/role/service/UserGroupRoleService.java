package com.management.role.service;

import com.management.role.model.UserGroupRoleModel;
import com.management.role.repository.UserGroupRoleRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * This class is a service for user group role
 */
@Singleton
public class UserGroupRoleService {

    @Inject
    private UserGroupRoleRepository userGroupRoleRepository;

    /**
     * This method is used for saving a user group role
     */
    public UserGroupRoleModel saveUserGroupRole(UserGroupRoleModel userGroupRoleModel) {
        return userGroupRoleRepository.save(userGroupRoleModel);
    }

    /**
     * This method is used for fetching all user group roles
     */
    public List<UserGroupRoleModel> getUserGroupRole() {
        return userGroupRoleRepository.findAll();
    }
}
