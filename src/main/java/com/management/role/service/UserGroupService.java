package com.management.role.service;

import com.management.role.model.UserGroupModel;
import com.management.role.repository.UserGroupRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * This class is a service for user group
 */
@Singleton
public class UserGroupService {

    @Inject
    private UserGroupRepository userGroupRepository;

    /**
     * This method is used for saving a user group
     */
    public UserGroupModel saveUserGroup(UserGroupModel userGroupModel) {
        return userGroupRepository.save(userGroupModel);
    }

    /**
     * This method is used for fetching all user groups
     */
    public List<UserGroupModel> getUserGroup() {
        return userGroupRepository.findAll();
    }

    /**
     * This method is used for updating a user group
     */
    public UserGroupModel updateUserGroup(String id, UserGroupModel userGroupModel) {
        userGroupModel.setUserGroupId(id);
        return userGroupRepository.update(userGroupModel);
    }

    /**
     * This method is used for deleting a user group
     */
    public void deleteUserGroup(String id) {
        userGroupRepository.deleteById(id);
    }
}
