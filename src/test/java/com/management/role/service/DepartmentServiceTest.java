package com.management.role.service;

import com.management.role.model.ActivityModel;
import com.management.role.model.DepartmentModel;
import com.management.role.repository.DepartmentRepository;
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
 class DepartmentServiceTest {


    @Inject
    DepartmentService departmentService;

    @Inject
    DepartmentRepository departmentRepository;

    @MockBean(DepartmentRepository.class)
    DepartmentRepository departmentRepository(){return mock(DepartmentRepository.class);}

    @Test
    void TestDeparmentService_success()
    {
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setDepartmentId("1");
        departmentModel.setDepartmentName("rk");
        when(departmentRepository.save(Mockito.any())).thenReturn(departmentModel);
        DepartmentModel save = departmentService.saveDepartment(departmentModel);
        assertNotNull(save);
    }

    @Test
    void TestGetActivityService()
    {
        List<DepartmentModel> departmentModels = new ArrayList<DepartmentModel>();
        when(departmentRepository.findAll()).thenReturn(departmentModels);
        List<DepartmentModel> get = departmentService.getDepartment();
        assertNotNull(get);
    }
    @Test
    void TestUpdateActivityService()
    {
        DepartmentModel departmentModel = new DepartmentModel();

        departmentModel.setDepartmentId("1");
        departmentModel.setDepartmentName("rk");
        when(departmentRepository.update(Mockito.any())).thenReturn(departmentModel);
        departmentService.updateDepartment(departmentModel.getDepartmentId(),departmentModel);
        assertNotNull(departmentModel);
    }

    @Test
    void TestDeleteActivityService()
    {
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setDepartmentId("1");
        departmentModel.setDepartmentName("rk");
        departmentService.deleteDepartment((departmentModel.getDepartmentId()));
    }



}
