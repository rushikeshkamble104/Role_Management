package com.management.role.service;

import com.management.role.model.DepartmentModel;
import com.management.role.repository.DepartmentRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * This class is a service for department
 */
@Singleton
public class DepartmentService {

    @Inject
    private DepartmentRepository departmentRepository;

    /**
     * This method is used for saving a department
     */
    public DepartmentModel saveDepartment(DepartmentModel departmentModel) {
        return departmentRepository.save(departmentModel);
    }

    /**
     * This method is used for fetching all departments
     */
    public List<DepartmentModel> getDepartment() {
        return departmentRepository.findAll();
    }

    /**
     * This method is used for updating a department
     */
    public void updateDepartment(String id, DepartmentModel departmentModel) {
        departmentModel.setDepartmentId(id);
        departmentRepository.update(departmentModel);
    }

    /**
     * This method is used for deleting a department
     */
    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }
}
