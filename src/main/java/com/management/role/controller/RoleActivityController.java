package com.management.role.controller;

import com.management.role.model.RoleActivityModel;
import com.management.role.service.RoleActivityService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

/**
 * This class is a controller for role activity
 */
@Controller
public class RoleActivityController {

    @Inject
    private RoleActivityService roleActivityService;

    /**
     * This method is used for saving role activity
     */
    @Post("/postroleactivity")
    public RoleActivityModel saveRoleActivity(@Body RoleActivityModel roleActivityModel) {
        return roleActivityService.saveRoleActivity(roleActivityModel);
    }

    /**
     * This method is used for fetching all role activities
     */
    @Get("/getroleactivity")
    public List<RoleActivityModel> getRoleActivity() {
        return roleActivityService.getRoleActivity();
    }
}