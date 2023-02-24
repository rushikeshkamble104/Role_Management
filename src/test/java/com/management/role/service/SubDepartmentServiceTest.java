package com.management.role.service;

import com.management.role.model.DepartmentModel;
import com.management.role.model.SubDepartmentModel;
import com.management.role.repository.SubDepartmentRepository;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class SubDepartmentServiceTest {

    @Inject
    SubDepartmentService subDepartmentService;
    @Inject
    SubDepartmentRepository subDepartmentRepository;

    @MockBean(SubDepartmentRepository.class)
    SubDepartmentRepository subDepartmentRepository(){return mock(SubDepartmentRepository.class);}

    @Test
    void TestSubDepartmentService_success()
    {
        SubDepartmentModel subDepartmentModel = new SubDepartmentModel();
        subDepartmentModel.setSubDepartmentId("1");
        subDepartmentModel.setSubDepartmentName("rk");
        when(subDepartmentRepository.save(Mockito.any())).thenReturn(subDepartmentModel);
        SubDepartmentModel save = subDepartmentService.saveSubDepartment(subDepartmentModel);
        assertNotNull(save);
    }

    @Test
    void TestGetSubDepartmentService()
    {
        List<SubDepartmentModel> subDepartmentModelList = new ArrayList<SubDepartmentModel>();
        when(subDepartmentRepository.findAll()).thenReturn(subDepartmentModelList);
        List<SubDepartmentModel> get = subDepartmentService.getSubDepartment();
        assertNotNull(get);
    }
    @Test
    void TestUpdateSubDepartmentService()
    {
        SubDepartmentModel subDepartmentModel = new SubDepartmentModel();

        subDepartmentModel.setSubDepartmentId("1");
        subDepartmentModel.setSubDepartmentName("rk");
        when(subDepartmentRepository.update(Mockito.any())).thenReturn(subDepartmentModel);
        subDepartmentService.updateSubDepartment(subDepartmentModel.getSubDepartmentId(),subDepartmentModel);
        assertNotNull(subDepartmentModel);
    }

    @Test
    void TestDeleteActivityService()
    {
        SubDepartmentModel subDepartmentModel = new SubDepartmentModel();

        subDepartmentModel.setSubDepartmentId("1");
        subDepartmentModel.setSubDepartmentName("rk");
        subDepartmentService.deleteSubDepartment((subDepartmentModel.getSubDepartmentId()));
    }

}
