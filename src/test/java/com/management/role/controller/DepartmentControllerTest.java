package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.DepartmentRequest;
import com.management.role.model.DepartmentModel;
import com.management.role.model.RoleByDepartmentModel;
import com.management.role.model.SubDepartmentModel;
import com.management.role.repository.DepartmentRepository;
import com.management.role.service.DepartmentService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.management.ConstructorParameters;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

@MicronautTest
 class DepartmentControllerTest {

    @Inject
    DepartmentController departmentController;

    @Inject
    DepartmentService departmentService;

    @Inject
    DepartmentRepository departmentRepository;

    @MockBean(DepartmentService.class)
    DepartmentService departmentService(){
        return mock(DepartmentService.class);
    }
    @MockBean(DepartmentRepository.class)
    DepartmentRepository departmentRepository(){
        return mock(DepartmentRepository.class);
    }
    @Test
    void DepartmentControllerSave_Success()
    {
        DepartmentRequest departmentRequest = new DepartmentRequest();
        departmentRequest.setDepartmentId("1");
        departmentRequest.setDepartmentName("Central operations");
        when(departmentRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = departmentController.saveDepartment(departmentRequest);
        assertEquals("success",messageResponse.getStatus());
    }
@Test
void  DepartmentControllerSave_Null_failure()
{
    DepartmentRequest departmentRequest = new DepartmentRequest();
    when(departmentRepository.existsById(Mockito.anyString())).thenReturn(false);
    MessageResponse messageResponse = departmentController.saveDepartment(departmentRequest);
    assertEquals("failure",messageResponse.getStatus());
}
    @Test
    void  DepartmentControllerSave_DepartmentId_BlankOrInvalid_failure()
    {
        DepartmentRequest departmentRequest = new DepartmentRequest();

        departmentRequest.setDepartmentId("friend");
        departmentRequest.setDepartmentName("Central operations");
        when(departmentRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = departmentController.saveDepartment(departmentRequest);
        assertEquals("failure",messageResponse.getStatus());
    }

    @Test
    void  DepartmentControllerSave_DepartmentId_IdALreadyExists_failure()
    {
        DepartmentRequest departmentRequest = new DepartmentRequest();
        departmentRequest.setDepartmentId("1");
        departmentRequest.setDepartmentName("Central operations");
        when(departmentRepository.existsById(Mockito.anyString())).thenReturn(true);
        MessageResponse messageResponse = departmentController.saveDepartment(departmentRequest);
        assertEquals("failure",messageResponse.getStatus());
    }
    @Test
    void  DepartmentControllerSave_DepartmentName_BlankOrNull_failure()
    {
        DepartmentRequest departmentRequest = new DepartmentRequest();
        departmentRequest.setDepartmentId("1");
        when(departmentRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = departmentController.saveDepartment(departmentRequest);
        assertEquals("failure",messageResponse.getStatus());
    }


@Test
void DepartmentControllerGet_Success()
{
    List<DepartmentModel> departmentModel = new ArrayList<>();
    when(departmentService.getDepartment()).thenReturn(departmentModel);
    List<DepartmentModel> department = departmentController.getDepartment();
    assertNotNull(department);

}
    @Test
    void DepartmentControllerUpdate_success()
    {
        DepartmentModel departmentModel = new DepartmentModel();
        doNothing().when(departmentService).updateDepartment(Mockito.any(),Mockito.any());
        MessageResponse messageResponse = departmentController.updateDepartment(departmentModel.getDepartmentId(), departmentModel);
        assertEquals("success",messageResponse.getStatus());
    }

    @Test
   void DepartmentControllerDelete_success(){
        DepartmentModel departmentModel = new DepartmentModel();
        doNothing().when(departmentService).deleteDepartment(Mockito.any());
        MessageResponse messageResponse = departmentController.deleteDepartment(departmentModel.getDepartmentId());
        assertEquals("success",messageResponse.getStatus());
    }

}
