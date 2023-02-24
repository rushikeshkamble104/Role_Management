package com.management.role.controller;

import com.management.role.model.ActivityPrivilegeModel;
import com.management.role.model.RoleActivityModel;
import com.management.role.repository.RoleActivityRepository;
import com.management.role.service.RoleActivityService;
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
 class RoleActivityControllerTest {

    @Inject
    RoleActivityController roleActivityController;

    @Inject
    RoleActivityService roleActivityService;

    @Inject
    RoleActivityRepository roleActivityRepository;

    @MockBean(RoleActivityService.class)
    RoleActivityService roleActivityService(){return mock(RoleActivityService.class);}

    @MockBean(RoleActivityRepository.class)
    RoleActivityRepository roleActivityRepository(){return mock(RoleActivityRepository.class);}

    @Test
    void roleActivitySave_success()
    {
        RoleActivityModel roleActivityModel = new RoleActivityModel();
        when(roleActivityService.saveRoleActivity(Mockito.any())).thenReturn(roleActivityModel);
        roleActivityController.saveRoleActivity(roleActivityModel);
        assertNotNull(roleActivityModel);
    }

    @Test
    void roleActivity_success()
    {
        List<RoleActivityModel> roleActivityModels = new ArrayList<>();
        when(roleActivityService.getRoleActivity()).thenReturn(roleActivityModels);
        List<RoleActivityModel> roleActivityModels1 = roleActivityController.getRoleActivity();
        assertNotNull(roleActivityModels1);
    }

}
