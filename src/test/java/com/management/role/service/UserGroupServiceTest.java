package com.management.role.service;

import com.management.role.model.DepartmentModel;
import com.management.role.model.UserGroupModel;
import com.management.role.repository.UserGroupRepository;
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
 class UserGroupServiceTest {

    @Inject
    UserGroupService userGroupService;

    @Inject
    UserGroupRepository userGroupRepository;

    @MockBean(UserGroupRepository.class)
    UserGroupRepository userGroupRepository(){return mock(UserGroupRepository.class);}

    @Test
    void TestUserGroupService_success()
    {
        UserGroupModel userGroupModel = new UserGroupModel();
        userGroupModel.setUserGroupId("1");
        userGroupModel.setUserGroupName("rk");
        when(userGroupRepository.save(Mockito.any())).thenReturn(userGroupModel);
        UserGroupModel save = userGroupService.saveUserGroup(userGroupModel);
        assertNotNull(save);
    }

    @Test
    void TestGetUserGroupService()
    {
        List<UserGroupModel> userGroupModels = new ArrayList<>();
        when(userGroupRepository.findAll()).thenReturn(userGroupModels);
        List<UserGroupModel> get = userGroupService.getUserGroup();
        assertNotNull(get);
    }
    @Test
    void TestUpdateUserGroupService()
    {
        UserGroupModel userGroupModel = new UserGroupModel();
        userGroupModel.setUserGroupId("1");
        userGroupModel.setUserGroupName("rk");
        when(userGroupRepository.update(Mockito.any())).thenReturn(userGroupModel);
        userGroupService.updateUserGroup(userGroupModel.getUserGroupId(),userGroupModel);
        assertNotNull(userGroupModel);
    }

    @Test
    void TestDeleteUserGroupService()
    {
        UserGroupModel userGroupModel = new UserGroupModel();
        userGroupModel.setUserGroupId("1");
        userGroupModel.setUserGroupName("rk");
        userGroupService.deleteUserGroup((userGroupModel.getUserGroupId()));
    }


}
