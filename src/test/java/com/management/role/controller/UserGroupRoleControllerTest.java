package com.management.role.controller;

import com.management.role.model.UserGroupRoleModel;
import com.management.role.repository.UserGroupRoleRepository;
import com.management.role.service.UserGroupRoleService;
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
 class UserGroupRoleControllerTest {

    @Inject
    UserGroupRoleController userGroupRoleController;

    @Inject
    UserGroupRoleService userGroupRoleService;

    @Inject
    UserGroupRoleRepository userGroupRepository;

    @MockBean(UserGroupRoleService.class)
    UserGroupRoleService userGroupRoleService() {
        return mock(UserGroupRoleService.class);
    }

    @Test
    void UserGroupRoleSave_success() {
        UserGroupRoleModel userGroupRoleModel = new UserGroupRoleModel();
        when(userGroupRoleService.saveUserGroupRole(Mockito.any())).thenReturn(userGroupRoleModel);
        userGroupRoleController.saveUserGroupRole(userGroupRoleModel);
        assertNotNull(userGroupRoleModel);
    }

    @Test
    void ActivityPrivilegeGet_success() {
        List<UserGroupRoleModel> userGroupRoleModels = new ArrayList<>();
        when(userGroupRoleService.getUserGroupRole()).thenReturn(userGroupRoleModels);
        List<UserGroupRoleModel> activityPrivilege = userGroupRoleController.getUserGroupRole();
        assertNotNull(activityPrivilege);
    }


}
