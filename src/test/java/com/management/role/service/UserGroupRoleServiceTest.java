package com.management.role.service;

import com.management.role.model.UserGroupRoleModel;
import com.management.role.repository.UserGroupRoleRepository;
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
class UserGroupRoleServiceTest {

    @Inject
    UserGroupRoleService userGroupRoleService;

    @Inject
    UserGroupRoleRepository userGroupRoleRepository;

    @MockBean(UserGroupRoleRepository.class)
    UserGroupRoleRepository userGroupRoleRepository(){return mock(UserGroupRoleRepository.class);}

    @Test
    void TestUserGroupRoleService_success()
    {
        UserGroupRoleModel userGroupRoleModel = new UserGroupRoleModel();
        userGroupRoleModel.setUserGroupRoleId(1);
        when(userGroupRoleRepository.save(Mockito.any())).thenReturn(userGroupRoleModel);
        UserGroupRoleModel save = userGroupRoleService.saveUserGroupRole(userGroupRoleModel);
        assertNotNull(save);
    }

    @Test
    void TestGetActivityService()
    {
        List<UserGroupRoleModel> userGroupRoleModelList = new ArrayList<>();
        when(userGroupRoleRepository.findAll()).thenReturn(userGroupRoleModelList);
        List<UserGroupRoleModel> get = userGroupRoleService.getUserGroupRole();
        assertNotNull(get);
    }
}
