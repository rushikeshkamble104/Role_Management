package com.management.role.service;

import com.management.role.model.PrivilegeModel;
import com.management.role.repository.PrivilegeRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * This class is a service for privilege
 */
@Singleton
public class PrivilegeService {

    @Inject
    private PrivilegeRepository privilegeRepository;

    /**
     * This method is used for saving a privilege
     */
    public PrivilegeModel savePrivilege(PrivilegeModel privilegeModel) {
        return privilegeRepository.save(privilegeModel);
    }

    /**
     * This method is used for fetching all privileges
     */
    public List<PrivilegeModel> getPrivilege() {
        return privilegeRepository.findAll();
    }

    /**
     * This method is used for updating a privilege
     */
    public PrivilegeModel updatePrivilege(String id, PrivilegeModel privilegeModel) {
        privilegeModel.setPrivilegeId(id);
        privilegeRepository.update(privilegeModel);
        return privilegeModel;
    }

    /**
     * This method is used for deleting a privilege
     */
    public void deletePrivilege(String id)
    {
        privilegeRepository.deleteById(id);
    }
}
