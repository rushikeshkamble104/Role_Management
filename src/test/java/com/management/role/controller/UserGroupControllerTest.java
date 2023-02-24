package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.UserGroupRequest;
import com.management.role.model.ActivityModel;
import com.management.role.model.UserGroupModel;
import com.management.role.repository.UserGroupRepository;
import com.management.role.service.UserGroupService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
 class UserGroupControllerTest {

    @Inject
    UserGroupController userGroupController;

    @Inject
    UserGroupService userGroupService;

    @Inject
    UserGroupRepository userGroupRepository;

    @MockBean(UserGroupService.class)
    UserGroupService userGroupService(){return mock(UserGroupService.class);}

    @MockBean(UserGroupRepository.class)
    UserGroupRepository userGroupRepository(){return mock(UserGroupRepository.class);}

    @Test
    void testGetUserGroupController(){
        List<UserGroupModel> userGroupModel = new ArrayList<>();
        when(userGroupService().getUserGroup()).thenReturn(userGroupModel);
        List<UserGroupModel> userGroup  = userGroupController.getUserGroup();
        assertNotNull(userGroup);
    }

    @Test
    void testUserGroup_Null_failure (){
        UserGroupRequest userGroupRequest = new UserGroupRequest();
        MessageResponse messageResponse = userGroupController.saveUserGroup(userGroupRequest);
        assertEquals("failure",messageResponse.getStatus());
    }

    @Test
    void testSaveUserGroup_UserGroupId_BlankOrNull_failure(){
        UserGroupRequest userGroupRequest = new UserGroupRequest();
        userGroupRequest.setUserGroupId("friend");
        userGroupRequest.setUserGroupName("idfc");
        MessageResponse messageResponse = userGroupController.saveUserGroup(userGroupRequest);
        assertEquals("failure",messageResponse.getStatus());
    }
    @Test
    void testSaveUserGroup_IdAlreadyExists_failure(){
        UserGroupRequest userGroupRequest = new UserGroupRequest();

        userGroupRequest.setUserGroupId("1");
        userGroupRequest.setUserGroupName("maker checker");
        when(userGroupRepository.existsById(Mockito.anyString())).thenReturn(true);
        MessageResponse messageResponse = userGroupController.saveUserGroup(userGroupRequest);
        assertEquals("failure",messageResponse.getStatus());
    }

    @Test
    void testSaveActivities_NameBlankOrNull_failure(){
        UserGroupRequest userGroupRequest = new UserGroupRequest();

        userGroupRequest.setUserGroupId("1");
        when(userGroupRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = userGroupController.saveUserGroup(userGroupRequest);
        assertEquals("failure",messageResponse.getStatus());
    }

    @Test
    void testSaveActivities_success(){
        UserGroupRequest userGroupRequest = new UserGroupRequest();

        userGroupRequest.setUserGroupId("1");
        userGroupRequest.setUserGroupName("maker checker");
        when(userGroupRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = userGroupController.saveUserGroup(userGroupRequest);
        assertEquals("success",messageResponse.getStatus());
    }

    @Test
    void testUpdateActivity() {
        UserGroupModel userGroupModel = new UserGroupModel();
        when(userGroupService.updateUserGroup(userGroupModel.getUserGroupId(),userGroupModel)).thenReturn(userGroupModel);
        MessageResponse messageResponse = userGroupController.updateUserGroup(userGroupModel.getUserGroupId(),userGroupModel);
        assertEquals("success",messageResponse.getStatus());
    }

    @Test
    void testDeleteActivity() {
        UserGroupModel userGroupModel = new UserGroupModel();
        doNothing().when(userGroupService).deleteUserGroup(userGroupModel.getUserGroupId());
        MessageResponse messageResponse = userGroupController.deleteUserGroup(userGroupModel.getUserGroupId());
        assertEquals("success",messageResponse.getStatus());
    }


}
