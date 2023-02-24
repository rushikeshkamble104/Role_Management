package com.management.role.service;

import com.management.role.model.RoleModel;
import com.management.role.repository.RoleRepository;
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
 class RoleServiceTest {

    @Inject
    RoleService roleService;

    @Inject
    RoleRepository roleRepository;
    
    @MockBean(RoleRepository.class)
    RoleRepository roleRepository(){
        return mock(RoleRepository.class);
    }

    @Test
    void TestSaveUserRoleService_success() {
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleId("1");
        roleModel.setRoleName("rk");
        roleModel.setRoleDescription("idfc");
        roleModel.setIsActive("true");
        when(roleRepository.save(roleModel)).thenReturn(roleModel);
        RoleModel save = roleService.saveRole(roleModel);
        assertNotNull(save);
    }

    @Test
    void TestGetUserRoleService() {
       List< RoleModel> roleModel = new ArrayList<RoleModel>();
        when(roleRepository.findAll()).thenReturn(roleModel);
        List<RoleModel> get = roleService.getRole();
        assertNotNull(get);
    }

    @Test
    void TestUpdateUserRoleService() {
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleId("1");
        roleModel.setRoleName("rk");
        roleModel.setRoleDescription("idfc");
        roleModel.setIsActive("true");
        when(roleRepository.update(roleModel)).thenReturn(roleModel);
        roleService.updateRole(roleModel.getRoleId(),roleModel);
        assertNotNull(roleModel);
    }

    @Test
    void TestDeleteUserRoleService() {
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleId("1");
        roleModel.setRoleName("rk");
        roleModel.setRoleDescription("idfc");
        roleModel.setIsActive("true");
        roleService.deleteRole(roleModel.getRoleId());
    }
}
