package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.UserGroupRequest;
import com.management.role.model.ActivityModel;
import com.management.role.model.UserGroupModel;
import com.management.role.repository.UserGroupRepository;
import com.management.role.service.UserGroupService;
import com.management.role.util.RBACEnum;
import com.management.role.util.RBACLogger;
import com.management.role.util.RBACUtility;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static com.management.role.util.RBACUtility.FAILURE;
import static com.management.role.util.RBACUtility.SUCCESS;

/**
 * This class is a controller for user group
 */
@Controller
public class UserGroupController {

    @Inject
    RBACLogger rbacLogger;
    @Inject
    private UserGroupService userGroupService;
    @Inject
    private UserGroupRepository userGroupRepository;
    final String className = getClass().getSimpleName();

    /**
     * This method is used for saving user group
     */
    @ReflectiveAccess
    @Post("/postusergroup")
    public MessageResponse saveUserGroup(@Body UserGroupRequest userGroupRequest) {

        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "saveUserGroup";

        if (RBACUtility.blankOrNullUserGroupId(userGroupRequest.getUserGroupId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateUserGroupIdRequest :: userGroupModel.getUserGroupId object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_USER_GROUP_ID_IS_BLANK_OR_NULL);
        }
        else if (RBACUtility.invalidUserGroupId(userGroupRequest.getUserGroupId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateUserGroupIdRequest :: userGroupModel.getUserGroupId object is invalid");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_USER_GROUP_ID_IS_INVALID);
        }
        else if (userGroupRepository.existsById(userGroupRequest.getUserGroupId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateUserGroupIdRequest :: userGroupModel.getUserGroupId object is already present in database");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_USER_GROUP_ID_ALREADY_EXISTS);
        }
        if (RBACUtility.blankOrNullUserGroupName(userGroupRequest.getUserGroupName())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateUserGroupNameRequest :: userGroupModel.getUserGroupName object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_USER_GROUP_NAME_BLANK_OR_NULL);
        }
        if (!rbacEnumList.isEmpty()) return RBACUtility.addMessage(FAILURE, rbacEnumList);
        else {
            final UserGroupModel userGroupModel = new UserGroupModel();
            userGroupModel.setUserGroupId(userGroupRequest.getUserGroupId());
            userGroupModel.setUserGroupName(userGroupRequest.getUserGroupName());
            userGroupService.saveUserGroup(userGroupModel);
            rbacLogger.logs(className, methodName, "User Group Validated and Added Successfully");
            rbacEnumList.add(RBACEnum.USER_GROUP_VALIDATED_AND_ADDED_SUCCESSFULLY);
            return RBACUtility.addMessage(SUCCESS, rbacEnumList);
        }
    }

    /**
     * This method is used for fetching all user groups
     */
    @Get("/getusergroup")
    public List<UserGroupModel> getUserGroup() {
        return userGroupService.getUserGroup();
    }

    /**
     * This method is used for updating user group
     */
    @Put("/updateusergroup/{id}")
    public MessageResponse updateUserGroup(@PathVariable String id, @Body UserGroupModel userGroupModel) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "updateUserGroup";
        userGroupService.updateUserGroup(id, userGroupModel);
        rbacLogger.logs(className, methodName, "User Group updated successfully");
        rbacEnumList.add(RBACEnum.USER_GROUP_UPDATED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }

    /**
     * This method is used for deleting user group
     */
    @Delete("/deleteusergroup/{id}")
    public MessageResponse deleteUserGroup(@PathVariable("id") String id) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "deleteUserGroup";
        userGroupService.deleteUserGroup(id);
        rbacLogger.logs(className, methodName, "User Group deleted successfully");
        rbacEnumList.add(RBACEnum.USER_GROUP_DELETED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }
}
