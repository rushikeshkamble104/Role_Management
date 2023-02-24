package com.management.role.controller;

import com.management.role.model.UserGroupRoleModel;
import com.management.role.service.UserGroupRoleService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

/**
 * This class is a controller for user group role
 */
@Controller
public class UserGroupRoleController {

    @Inject
    private UserGroupRoleService userGroupRoleService;

    /**
     * This method is used for saving user group role
     */
    @Post("/postusergrouprole")
    public UserGroupRoleModel saveUserGroupRole(@Body UserGroupRoleModel userGroupRoleModel) {
        return userGroupRoleService.saveUserGroupRole(userGroupRoleModel);
    }

    /**
     * This method is used for fetching all user group roles
     */
    @Get("/getusergrouprole")
    public List<UserGroupRoleModel> getUserGroupRole() {
        return userGroupRoleService.getUserGroupRole();
    }
}