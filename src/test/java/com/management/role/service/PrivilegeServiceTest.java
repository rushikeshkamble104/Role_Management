package com.management.role.service;

import com.management.role.model.PrivilegeModel;
import com.management.role.repository.PrivilegeRepository;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
 class PrivilegeServiceTest {
    @Inject
    PrivilegeService privilegesService;

    @Inject
    PrivilegeRepository privilegesRepository;

    @MockBean(PrivilegeRepository.class)
    PrivilegeRepository privilegesRepository() {return mock(PrivilegeRepository.class);}

    @Test
    void TestPrivilegeService_success()
    {
        PrivilegeModel privilegesModel = new PrivilegeModel();
        privilegesModel.setPrivilegeId("1");
        privilegesModel.setPrivilegeName("rk");
        privilegesModel.setDescription("idfc");
        when(privilegesRepository.save(privilegesModel)).thenReturn(privilegesModel);
        PrivilegeModel save = privilegesService.savePrivilege(privilegesModel);
        assertNotNull(save);
    }

    @Test
    void TestGetPrivilegeService()
    {
        List<PrivilegeModel> privilegesModels = new ArrayList<PrivilegeModel>();
        when(privilegesRepository.findAll()).thenReturn(privilegesModels);
        List<PrivilegeModel> get = privilegesService.getPrivilege();
        assertNotNull(get);
    }
    @Test
    void TestUpdatePrivilegeService()
    {
        PrivilegeModel privilegesModel = new PrivilegeModel();
        privilegesModel.setPrivilegeId("1");
        privilegesModel.setPrivilegeName("rk");
        privilegesModel.setDescription("idfc");
        when(privilegesRepository.update(privilegesModel)).thenReturn(privilegesModel);
        privilegesService.updatePrivilege(privilegesModel.getPrivilegeId(),privilegesModel);
        assertNotNull(privilegesModel);
    }

    @Test
    void TestDeletePrivilegeService()
    {
        PrivilegeModel privilegesModel = new PrivilegeModel();
        privilegesModel.setPrivilegeId("1");
        privilegesModel.setPrivilegeName("rk");
        privilegesModel.setDescription("idfc");
        privilegesService.deletePrivilege((privilegesModel.getPrivilegeId()));

    }


}
