package com.management.role.service;

import com.management.role.model.SubDepartmentModel;
import com.management.role.repository.SubDepartmentRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * This class is a service for sub department
 */
@Singleton
public class SubDepartmentService {

    @Inject
    private SubDepartmentRepository subDepartmentRepository;

    /**
     * This method is used for saving a sub department
     */
    public SubDepartmentModel saveSubDepartment(SubDepartmentModel subDepartmentModel) {
        return subDepartmentRepository.save(subDepartmentModel);
    }

    /**
     * This method is used for fetching all sub departments
     */
    public List<SubDepartmentModel> getSubDepartment() {
        return subDepartmentRepository.findAll();
    }

    /**
     * This method is used for updating a sub department
     */
    public SubDepartmentModel updateSubDepartment(String id, SubDepartmentModel subDepartmentModel) {
        subDepartmentModel.setSubDepartmentId(id);
        return subDepartmentRepository.update(subDepartmentModel);
    }

    /**
     * This method is used for deleting a sub department
     */
    public void deleteSubDepartment(String id) {
        subDepartmentRepository.deleteById(id);
    }
}
