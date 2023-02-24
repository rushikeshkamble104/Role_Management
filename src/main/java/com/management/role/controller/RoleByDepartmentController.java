package com.management.role.controller;

import com.management.role.model.RoleByDepartmentModel;
import com.management.role.service.RoleByDepartmentService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

/**
 * This class is a controller for role by department
 */
@Controller
public class RoleByDepartmentController {

    @Inject
    private RoleByDepartmentService roleByDepartmentService;

    /**
     * This method is used for saving role by department
     */
    @Post("/postrolebydepartment")
    public RoleByDepartmentModel saveRoleByDepartment(@Body RoleByDepartmentModel roleByDepartmentModel) {
        return roleByDepartmentService.saveRoleByDepartment(roleByDepartmentModel);
    }

    /**
     * This method is used for fetching all role by departments
     */
    @Get("/getrolebydepartment")
    public List<RoleByDepartmentModel> getRoleByDepartment() {
        return roleByDepartmentService.getRoleByDepartment();
    }
}
