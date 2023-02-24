package com.management.role.service;

import com.management.role.model.RoleActivityModel;
import com.management.role.repository.RoleActivityRepository;
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
 class RoleActivityServiceTest {

    @Inject
    RoleActivityService roleActivityService;

    @Inject
    RoleActivityRepository roleActivityRepository;

    @MockBean(RoleActivityRepository.class)
    RoleActivityRepository roleActivityRepository(){return mock(RoleActivityRepository.class);}

    @Test
    void TestActivityService_success()
    {
        RoleActivityModel roleActivityModel = new RoleActivityModel();
        roleActivityModel.setRoleActivityId(1);
        when(roleActivityRepository.save(Mockito.any())).thenReturn(roleActivityModel);
        RoleActivityModel save = roleActivityService.saveRoleActivity(roleActivityModel);
        assertNotNull(save);
    }

    @Test
    void TestGetActivityService()
    {
        List<RoleActivityModel> roleActivityModel = new ArrayList<>();
        when(roleActivityRepository.findAll()).thenReturn(roleActivityModel);
        List<RoleActivityModel> get = roleActivityService.getRoleActivity();
        assertNotNull(get);
    }

}
