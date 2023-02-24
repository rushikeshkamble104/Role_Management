package com.management.role.service;

import com.management.role.model.RoleActivityModel;
import com.management.role.model.RoleByDepartmentModel;
import com.management.role.repository.RoleByDepartmentRepository;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class RoleByDepartmentServiceTest {

    @Inject
    RoleByDepartmentService roleByDepartmentService;

    @Inject
    RoleByDepartmentRepository roleByDepartmentRepository;


    @MockBean(RoleByDepartmentRepository.class)
    RoleByDepartmentRepository roleByDepartmentRepository(){return mock(RoleByDepartmentRepository.class);}


    @Test
    void TestRoleByDepartmentService_success()
    {
        RoleByDepartmentModel roleByDepartmentModel = new RoleByDepartmentModel();
        roleByDepartmentModel.setRoleByDepartmentId(1);
        when(roleByDepartmentRepository.save(Mockito.any())).thenReturn(roleByDepartmentModel);
        RoleByDepartmentModel save = roleByDepartmentService.saveRoleByDepartment(roleByDepartmentModel);
        assertNotNull(save);
    }

    @Test
    void TestRoleByDepartmentService()
    {
        List<RoleByDepartmentModel> roleByDepartmentModels = new ArrayList<>();
        when(roleByDepartmentRepository.findAll()).thenReturn(roleByDepartmentModels);
        List<RoleByDepartmentModel> get = roleByDepartmentService.getRoleByDepartment();
        assertNotNull(get);
    }
}
