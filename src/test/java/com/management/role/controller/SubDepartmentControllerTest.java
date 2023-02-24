package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.SubDepartmentRequest;
import com.management.role.model.SubDepartmentModel;
import com.management.role.repository.SubDepartmentRepository;
import com.management.role.service.SubDepartmentService;
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
 class SubDepartmentControllerTest {

    @Inject
    SubDepartmentController subDepartmentController;

    @Inject
    SubDepartmentService subDepartmentService;

    @Inject
    SubDepartmentRepository subDepartmentRepository;

    @MockBean(SubDepartmentService.class)
    SubDepartmentService subDepartmentService(){return mock(SubDepartmentService.class);}

    @MockBean(SubDepartmentRepository.class)
    SubDepartmentRepository subDepartmentRepository(){return mock(SubDepartmentRepository.class);}


   @Test
   void testGetSubDepartmentController(){
      List<SubDepartmentModel> subDepartmentModels = new ArrayList<>();
      when(subDepartmentService().getSubDepartment()).thenReturn(subDepartmentModels);
      List<SubDepartmentModel> subDepartment  = subDepartmentController.getSubDepartment();
      assertNotNull(subDepartment);
   }

   @Test
   void testSubDepartment_null_failure (){
       SubDepartmentRequest subDepartmentRequest = new SubDepartmentRequest();
      MessageResponse messageResponse = subDepartmentController.saveSubDepartment(subDepartmentRequest);
      assertEquals("failure",messageResponse.getStatus());
   }

    @Test
    void testSaveActivities_InvalidId(){
        SubDepartmentRequest subDepartmentRequest = new SubDepartmentRequest();
        subDepartmentRequest.setSubDepartmentId("friend");
        subDepartmentRequest.setSubDepartmentName("maker checker");
        when(subDepartmentRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = subDepartmentController.saveSubDepartment(subDepartmentRequest);
        assertEquals("failure",messageResponse.getStatus());
    }
    @Test
    void testSaveActivities_ExistsId_failure(){
        SubDepartmentRequest subDepartmentRequest = new SubDepartmentRequest();
        subDepartmentRequest.setSubDepartmentId("1");
        subDepartmentRequest.setSubDepartmentName("maker checker");
        when(subDepartmentRepository.existsById(Mockito.anyString())).thenReturn(true);
        MessageResponse messageResponse = subDepartmentController.saveSubDepartment(subDepartmentRequest);
        assertEquals("failure",messageResponse.getStatus());
    }


    @Test
    void testSaveActivities_DepartmentName_Null_failure(){
        SubDepartmentRequest subDepartmentRequest = new SubDepartmentRequest();

        subDepartmentRequest.setSubDepartmentId("1");
//        subDepartmentRequest.setSubDepartmentName("maker checker");
        when(subDepartmentRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = subDepartmentController.saveSubDepartment(subDepartmentRequest);
        assertEquals("failure",messageResponse.getStatus());
    }
   @Test
   void testSaveActivities_success(){
       SubDepartmentRequest subDepartmentRequest = new SubDepartmentRequest();

       subDepartmentRequest.setSubDepartmentId("1");
      subDepartmentRequest.setSubDepartmentName("maker checker");
      when(subDepartmentRepository.existsById(Mockito.anyString())).thenReturn(false);
      MessageResponse messageResponse = subDepartmentController.saveSubDepartment(subDepartmentRequest);
      assertEquals("success",messageResponse.getStatus());
   }

   @Test
   void testUpdateActivity() {
      SubDepartmentModel subDepartmentModel = new SubDepartmentModel();
       when(subDepartmentService.updateSubDepartment(subDepartmentModel.getSubDepartmentId(), subDepartmentModel)).thenReturn(subDepartmentModel);
      MessageResponse messageResponse = subDepartmentController.updateSubDepartment(subDepartmentModel.getSubDepartmentId(),subDepartmentModel);
      assertEquals("success",messageResponse.getStatus());
   }

   @Test
   void testDeleteActivity() {
       SubDepartmentModel subDepartmentModel = new SubDepartmentModel();
      doNothing().when(subDepartmentService).deleteSubDepartment(subDepartmentModel.getSubDepartmentId());
      MessageResponse messageResponse = subDepartmentController.deleteSubDepartment(subDepartmentModel.getSubDepartmentId());
      assertEquals("success",messageResponse.getStatus());
   }
}

