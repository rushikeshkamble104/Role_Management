package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.PrivilegeRequest;
import com.management.role.model.PrivilegeModel;
import com.management.role.repository.PrivilegeRepository;
import com.management.role.service.PrivilegeService;
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
 class PrivilegeControllerTest {

    @Inject
    PrivilegeController privilegeController;
    
    @Inject
    PrivilegeRepository privilegeRepository;

    @Inject
    PrivilegeService privilegeService;

    @MockBean(PrivilegeService.class)
    PrivilegeService privilegeService(){
        return mock(PrivilegeService.class);}

    @MockBean(PrivilegeRepository.class)
    PrivilegeRepository privilegesRepository(){
        return mock(PrivilegeRepository.class);}

    @Test
    void testPrivilege(){
        List<PrivilegeModel> PrivilegesModelList = new ArrayList<>();
        when(privilegeService().getPrivilege()).thenReturn(PrivilegesModelList);
        List<PrivilegeModel> PrivilegeModels  = privilegeController.getPrivilege();
        assertNotNull(PrivilegeModels);
    }

    @Test
    void TestSavePrivilegesController_null_failure(){
        PrivilegeRequest privilegeRequest = new PrivilegeRequest();
        MessageResponse messageResponse = privilegeController.savePrivilege(privilegeRequest);
        assertEquals("failure",messageResponse.getStatus());
    }
    @Test
    void testSavePrivilege_PrivilegeDescriptionBlankOrNull_failure(){
        PrivilegeRequest privilegeRequest = new PrivilegeRequest();
        privilegeRequest.setPrivilegeId("1");
        privilegeRequest.setPrivilegeName("download");
//        PrivilegeModel.setDescription("ok");
        privilegeRequest.setCreatedBy("rupesh");
        privilegeRequest.setUpdatedBy("rupesh");
        privilegeRequest.setCreatedDate("08/12/2022");
        privilegeRequest.setUpdatedDate("08/12/2022");
        when(privilegeRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = privilegeController.savePrivilege(privilegeRequest);
        assertEquals("failure",messageResponse.getStatus());
    }
    @Test
    void testSavePrivilege_CreatedByBlankOrNull_failure(){
        PrivilegeRequest privilegeRequest = new PrivilegeRequest();
        privilegeRequest.setPrivilegeId("1");
        privilegeRequest.setPrivilegeName("download");
        privilegeRequest.setDescription("ok");
//        privilegeRequest.setCreatedBy("rupesh");
        privilegeRequest.setUpdatedBy("rupesh");
        privilegeRequest.setCreatedDate("08/12/2022");
        privilegeRequest.setUpdatedDate("08/12/2022");
        when(privilegeRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = privilegeController.savePrivilege(privilegeRequest);
        assertEquals("failure",messageResponse.getStatus());
    }  @Test
    void testSavePrivilege_NameBlankOrNull_failure(){
        PrivilegeRequest privilegeRequest = new PrivilegeRequest();
        privilegeRequest.setPrivilegeId("1");
      // privilegeRequest.setPrivilegeName("download");
        privilegeRequest.setDescription("ok");
        privilegeRequest.setCreatedBy("rupesh");
        privilegeRequest.setUpdatedBy("rupesh");
        privilegeRequest.setCreatedDate("08/12/2022");
        privilegeRequest.setUpdatedDate("08/12/2022");
        when(privilegeRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = privilegeController.savePrivilege(privilegeRequest);
        assertEquals("failure",messageResponse.getStatus());
    }


    @Test
    void testSavePrivilege_CreatedDateBlankOrNull_failure(){
        PrivilegeRequest privilegeRequest = new PrivilegeRequest();
        privilegeRequest.setPrivilegeId("1");
        privilegeRequest.setPrivilegeName("download");
        privilegeRequest.setDescription("ok");
        privilegeRequest.setCreatedBy("rupesh");
        privilegeRequest.setUpdatedBy("rupesh");
//        privilegeRequest.setCreatedDate("08/12/2022");
        privilegeRequest.setUpdatedDate("08/12/2022");
        when(privilegeRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = privilegeController.savePrivilege(privilegeRequest);
        assertEquals("failure",messageResponse.getStatus());

    }

    @Test
    void testSavePrivilege_UpdatedByBlankOrNull_failure(){
        PrivilegeRequest privilegeRequest = new PrivilegeRequest();
        privilegeRequest.setPrivilegeId("1");
        privilegeRequest.setPrivilegeName("download");
        privilegeRequest.setDescription("ok");
        privilegeRequest.setCreatedBy("rupesh");
//        privilegeRequest.setUpdatedBy("rupesh");
        privilegeRequest.setCreatedDate("08/12/2022");
        privilegeRequest.setUpdatedDate("08/12/2022");
        when(privilegeRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = privilegeController.savePrivilege(privilegeRequest);
        assertEquals("failure",messageResponse.getStatus());
    }

    @Test
    void testSavePrivilege_UpdatedDateBlankOrNull_failure(){
        PrivilegeRequest privilegeRequest = new PrivilegeRequest();
        privilegeRequest.setPrivilegeId("1");
        privilegeRequest.setPrivilegeName("download");
        privilegeRequest.setDescription("ok");
        privilegeRequest.setCreatedBy("rupesh");
        privilegeRequest.setUpdatedBy("rupesh");
        privilegeRequest.setCreatedDate("08/12/2022");
//        privilegeRequest.setUpdatedDate("08/12/2022");
        when(privilegeRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = privilegeController.savePrivilege(privilegeRequest);
        assertEquals("failure",messageResponse.getStatus());

    }

    @Test
    void testSavePrivilege_IdInvalid_failure(){
        PrivilegeRequest privilegeRequest = new PrivilegeRequest();
        privilegeRequest.setPrivilegeId("Friend");
        privilegeRequest.setPrivilegeName("download");
        privilegeRequest.setDescription("ok");
        privilegeRequest.setCreatedBy("rupesh");
        privilegeRequest.setUpdatedBy("rupesh");
        privilegeRequest.setCreatedDate("08/12/2022");
        privilegeRequest.setUpdatedDate("08/12/2022");
        when(privilegeRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = privilegeController.savePrivilege(privilegeRequest);
        assertEquals("failure",messageResponse.getStatus());
    }
    @Test
    void testSavePrivilege_IdExists_failure(){
        PrivilegeRequest privilegeRequest = new PrivilegeRequest();
        privilegeRequest.setPrivilegeId("1");
        privilegeRequest.setPrivilegeName("download");
        privilegeRequest.setDescription("ok");
        privilegeRequest.setCreatedBy("rupesh");
        privilegeRequest.setUpdatedBy("rupesh");
        privilegeRequest.setCreatedDate("08/12/2022");
        privilegeRequest.setUpdatedDate("08/12/2022");
        when(privilegeRepository.existsById(Mockito.anyString())).thenReturn(true);
        MessageResponse messageResponse = privilegeController.savePrivilege(privilegeRequest);
        assertEquals("failure",messageResponse.getStatus());

    }
    @Test
    void testSavePrivilege_success(){
        PrivilegeRequest privilegeRequest = new PrivilegeRequest();
        privilegeRequest.setPrivilegeId("1");
        privilegeRequest.setPrivilegeName("download");
        privilegeRequest.setDescription("ok");
        privilegeRequest.setCreatedBy("rupesh");
        privilegeRequest.setUpdatedBy("rupesh");
        privilegeRequest.setCreatedDate("08/12/2022");
        privilegeRequest.setUpdatedDate("08/12/2022");
        when(privilegeRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = privilegeController.savePrivilege(privilegeRequest);
        assertEquals("success",messageResponse.getStatus());

    }

    @Test
    void testUpdatePrivilege() {
        PrivilegeModel privilegesModel = new PrivilegeModel();
        when(privilegeService.updatePrivilege(privilegesModel.getPrivilegeId(), privilegesModel)).thenReturn(new PrivilegeModel());
        MessageResponse messageResponse = privilegeController.updatePrivilege(privilegesModel.getPrivilegeId(), privilegesModel);
        assertEquals("success",messageResponse.getStatus());
    }

    @Test
    void testDeletePrivilege() {
        PrivilegeModel privilegesModel = new PrivilegeModel();
        doNothing().when(privilegeService).deletePrivilege(privilegesModel.getPrivilegeId());
        MessageResponse messageResponse = privilegeController.deletePrivilege(privilegesModel.getPrivilegeId());
        assertEquals("success",messageResponse.getStatus());
    }


}
