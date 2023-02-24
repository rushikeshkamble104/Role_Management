package com.management.role.controller;

import com.management.role.model.RoleActivityModel;
import com.management.role.model.RoleByDepartmentModel;
import com.management.role.service.RoleByDepartmentService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
 class RoleByDepartmentControllerTest {

    @Inject
    RoleByDepartmentController roleByDepartmentController;

    @Inject
    RoleByDepartmentService roleByDepartmentService;

    @MockBean(RoleByDepartmentService.class)
   RoleByDepartmentService roleByDepartmentService()
    {
        return mock(RoleByDepartmentService.class);
    }


    @Test
    void roleByDepartmentSave_success()
    {
        RoleByDepartmentModel roleByDepartmentModel =new RoleByDepartmentModel();
        when(roleByDepartmentService.saveRoleByDepartment(Mockito.any())).thenReturn(roleByDepartmentModel);
        roleByDepartmentController.saveRoleByDepartment(roleByDepartmentModel);
        assertNotNull(roleByDepartmentModel);
    }

    @Test
    void ActivityPrivilegeGet_success()
    {
        List<RoleByDepartmentModel> roleByDepartmentModels = new ArrayList<>();
        when(roleByDepartmentService.getRoleByDepartment()).thenReturn(roleByDepartmentModels);
        List<RoleByDepartmentModel> roleActivityModels = roleByDepartmentController.getRoleByDepartment();
        assertNotNull(roleActivityModels);
    }
}
