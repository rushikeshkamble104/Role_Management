package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.RoleRequest;
import com.management.role.model.RoleModel;
import com.management.role.repository.RoleRepository;
import com.management.role.service.RoleService;
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
 class RoleControllerTest {

    @Inject
    RoleController roleController;

    @Inject
    RoleService roleService;

    @Inject
    RoleRepository roleRepository;

    @MockBean(RoleService.class)
    RoleService service() {
        return mock(RoleService.class);
    }

    @MockBean(RoleRepository.class)
    RoleRepository repository() {
        return mock(RoleRepository.class);
    }

    @Test
    void testGetRoleController() {
        List<RoleModel> roleModels = new ArrayList<>();
        when(roleService.getRole()).thenReturn(roleModels);
        List<RoleModel> RoleController1 = roleController.getRole();
        assertNotNull(RoleController1);
    }

    @Test
    void testSaveUserRoleController_RoleId_null() {
        RoleRequest roleRequest = new RoleRequest();
        MessageResponse messageResponse = roleController.saveRole(roleRequest);
        assertEquals("failure", messageResponse.getStatus());
    }


    @Test
    void testSaveRoleController_RoleId_invalid_failure() {
        RoleRequest roleRequest = new RoleRequest();
        roleRequest.setRoleId("friend");
        roleRequest.setIsActive("true");
        roleRequest.setRoleDescription("idfc");
        roleRequest.setRoleName("Software engineer");
        roleRequest.setCreatedDate("08/12/2022");
        roleRequest.setCreatedBy("rupesh");
        roleRequest.setUpdatedBy("rupesh");
        roleRequest.setUpdatedDate("08/12/2022");
        MessageResponse messageResponse = roleController.saveRole(roleRequest);
        assertEquals("failure", messageResponse.getStatus());
    }

    @Test
    void testSaveRoleController_RoleId_Exists_failure() {
        RoleRequest roleRequest = new RoleRequest();
        roleRequest.setRoleId("1");
        roleRequest.setIsActive("true");
        roleRequest.setRoleDescription("idfc");
        roleRequest.setRoleName("Software engineer");
        roleRequest.setCreatedDate("08/12/2022");
        roleRequest.setCreatedBy("rupesh");
        roleRequest.setUpdatedBy("rupesh");
        roleRequest.setUpdatedDate("08/12/2022");
        when(roleRepository.existsById(Mockito.anyString())).thenReturn(true);
        MessageResponse messageResponse = roleController.saveRole(roleRequest);
        assertEquals("failure", messageResponse.getStatus());
    }

    @Test
    void testSaveRoleController_RoleName_BlankOrNull_failure() {
        RoleRequest roleRequest = new RoleRequest();
        roleRequest.setIsActive("true");
        roleRequest.setRoleDescription("idfc");
        roleRequest.setCreatedDate("08/12/2022");
        roleRequest.setCreatedBy("rupesh");
        roleRequest.setUpdatedBy("rupesh");
        roleRequest.setUpdatedDate("08/12/2022");
        MessageResponse messageResponse = roleController.saveRole(roleRequest);
        assertEquals("failure", messageResponse.getStatus());
    }

    @Test
    void testSaveRoleController_RoleDescription_BlankOrNull_failure() {
        RoleRequest roleRequest = new RoleRequest();

        roleRequest.setRoleId("5");
        roleRequest.setIsActive("true");
        roleRequest.setRoleName("software engineer");
        roleRequest.setCreatedDate("08/12/2022");
        roleRequest.setCreatedBy("rupesh");
        roleRequest.setUpdatedBy("rupesh");
        roleRequest.setUpdatedDate("08/12/2022");
        MessageResponse messageResponse = roleController.saveRole(roleRequest);
        assertEquals("failure", messageResponse.getStatus());
    }

    @Test
    void testSaveRoleController_RoleCreatedDate_BlankOrNull_failure() {
        RoleRequest roleRequest = new RoleRequest();

        roleRequest.setRoleId("5");
        roleRequest.setIsActive("true");
        roleRequest.setRoleName("software engineer");
        roleRequest.setRoleDescription("idfc");
        //roleRequest.setCreatedDate("08/12/2022");
        roleRequest.setCreatedBy("rupesh");
        roleRequest.setUpdatedBy("rupesh");
        roleRequest.setUpdatedDate("08/12/2022");
        MessageResponse messageResponse = roleController.saveRole(roleRequest);
        assertEquals("failure", messageResponse.getStatus());
    }
    @Test
    void testSaveRoleController_RoleUpdatedDate_BlankOrNull_failure() {
        RoleRequest roleRequest = new RoleRequest();

        roleRequest.setRoleId("5");
        roleRequest.setIsActive("true");
        roleRequest.setRoleName("software engineer");
        roleRequest.setRoleDescription("idfc");
        roleRequest.setCreatedDate("08/12/2022");
        roleRequest.setCreatedBy("rupesh");
        roleRequest.setUpdatedBy("rupesh");
        //roleRequest.setUpdatedDate("08/12/2022");
        MessageResponse messageResponse = roleController.saveRole(roleRequest);
        assertEquals("failure", messageResponse.getStatus());
    }
    @Test
    void testSaveRoleController_RoleCreatedBy_BlankOrNull_failure() {
        RoleRequest roleRequest = new RoleRequest();

        roleRequest.setRoleId("5");
        roleRequest.setIsActive("true");
        roleRequest.setRoleDescription("idfc");
        roleRequest.setRoleName("software engineer");
        roleRequest.setCreatedDate("08/12/2022");
        roleRequest.setUpdatedBy("rupesh");
        roleRequest.setUpdatedDate("08/12/2022");
        MessageResponse messageResponse = roleController.saveRole(roleRequest);
        assertEquals("failure", messageResponse.getStatus());
    }


    @Test
    void testSaveRoleController_RoleUpdatedBy_BlankOrNull_failure() {
        RoleRequest roleRequest = new RoleRequest();

        roleRequest.setRoleId("5");
        roleRequest.setIsActive("true");
        roleRequest.setRoleDescription("idfc");
        roleRequest.setRoleName("software engineer");
        roleRequest.setCreatedDate("08/12/2022");
//        roleRequest.setUpdatedBy("rupesh");
        roleRequest.setUpdatedDate("08/12/2022");
        MessageResponse messageResponse = roleController.saveRole(roleRequest);
        assertEquals("failure", messageResponse.getStatus());
    }


    @Test
    void testSaveRoleController_RoleActiveStatus_Invalid_failure() {
        RoleRequest roleRequest = new RoleRequest();

        roleRequest.setRoleId("1");
        roleRequest.setIsActive("yes");
        roleRequest.setRoleName("software engineer");
        roleRequest.setRoleDescription("idfc");
        roleRequest.setCreatedDate("08/12/2022");
        roleRequest.setCreatedBy("rupesh");
        roleRequest.setUpdatedBy("rupesh");
        roleRequest.setUpdatedDate("08/12/2022");
        MessageResponse messageResponse = roleController.saveRole(roleRequest);
        assertEquals("failure", messageResponse.getStatus());
    }

    @Test
    void testSaveRoleController_success(){
        RoleRequest roleRequest = new RoleRequest();
        roleRequest.setRoleId("5");
        roleRequest.setIsActive("true");
        roleRequest.setRoleDescription("idfc");
        roleRequest.setRoleName("Software engineer");
        roleRequest.setCreatedDate("08/12/2022");
        roleRequest.setCreatedBy("rupesh");
        roleRequest.setUpdatedBy("rupesh");
        roleRequest.setUpdatedDate("08/12/2022");
        when(roleRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = roleController.saveRole(roleRequest);
        assertEquals("success",messageResponse.getStatus());
        assertEquals(200,messageResponse.getStatusCode());
        assertEquals("EAZ-200",messageResponse.getCode());
        assertEquals("Success - Role validated and added successfully",messageResponse.getMessages().get(0).getMessages());

    }


    @Test
    void testUpdateUserRoleController() {
        RoleModel roleModel = new RoleModel();
        when(roleService.updateRole(roleModel.getRoleId(), roleModel)).thenReturn(new RoleModel());
        MessageResponse messageResponse = roleController.updateRole(roleModel.getRoleId(), roleModel);
        assertEquals("success",messageResponse.getStatus());
        assertNotNull(roleModel);
    }

    @Test
    void testDeleteUserRoleController() {
        RoleModel roleModel = new RoleModel();
        doNothing().when(roleService).deleteRole(roleModel.getRoleId());
        MessageResponse messageResponse = roleController.deleteRole(roleModel.getRoleId());
        assertEquals("success",messageResponse.getStatus());

    }
}