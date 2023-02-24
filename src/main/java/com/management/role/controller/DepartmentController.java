package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.DepartmentRequest;
import com.management.role.model.DepartmentModel;
import com.management.role.repository.DepartmentRepository;
import com.management.role.service.DepartmentService;
import com.management.role.util.RBACEnum;
import com.management.role.util.RBACLogger;
import com.management.role.util.RBACUtility;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static com.management.role.util.RBACUtility.FAILURE;
import static com.management.role.util.RBACUtility.SUCCESS;

/**
 * This class is a controller for department
 */
@Controller
public class DepartmentController {


    @Inject
    RBACLogger rbacLogger;

    @Inject
    private DepartmentService departmentService;

    @Inject
    private DepartmentRepository departmentRepository;

    final String className = getClass().getSimpleName();

    /**
     * This method is used for saving department
     */
    @ReflectiveAccess
    @Post("/postdepartment")
    public MessageResponse saveDepartment(@Body DepartmentRequest departmentRequest) {

        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "saveDepartment";

        if (RBACUtility.blankOrNullDepartmentId(departmentRequest.getDepartmentId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateDepartmentIdRequest :: departmentModel.getDepartmentId object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_DEPARTMENT_ID_IS_BLANK_OR_NULL);
        }
        else if (RBACUtility.invalidDepartmentId(departmentRequest.getDepartmentId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateDepartmentIdRequest :: departmentModel.getDepartmentId object is invalid");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_DEPARTMENT_ID_IS_INVALID);
        }
        else if (departmentRepository.existsById(departmentRequest.getDepartmentId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateDepartmentIdRequest :: departmentModel.getDepartmentId object is already present in database");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_DEPARTMENT_ID_ALREADY_EXISTS);
        }
        if (RBACUtility.blankOrNullDepartmentName(departmentRequest.getDepartmentName())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateDepartmentNameRequest :: departmentModel.getDepartmentName object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_DEPARTMENT_NAME_BLANK_OR_NULL);
        }
        if (!rbacEnumList.isEmpty()) return RBACUtility.addMessage(FAILURE, rbacEnumList);
        else {
            final DepartmentModel departmentModel = new DepartmentModel();
            departmentModel.setDepartmentId(departmentRequest.getDepartmentId());
            departmentModel.setDepartmentName(departmentRequest.getDepartmentName());
            departmentService.saveDepartment(departmentModel);
            rbacLogger.logs(className, methodName, "Department Validated and Added Successfully");
            rbacEnumList.add(RBACEnum.DEPARTMENT_VALIDATED_AND_ADDED_SUCCESSFULLY);
            return RBACUtility.addMessage(SUCCESS, rbacEnumList);
        }
    }

    /**
     * This method is used for fetching all departments
     */
    @Get("/getdepartment")
    public List<DepartmentModel> getDepartment() {
        return departmentService.getDepartment();
    }

    /**
     * This method is used for updating department
     */
    @Put("/updatedepartment/{id}")
    public MessageResponse updateDepartment(@PathVariable String id, @Body DepartmentModel departmentModel) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "updateDepartment";
        departmentService.updateDepartment(id, departmentModel);
        rbacLogger.logs(className, methodName, "Department updated successfully");
        rbacEnumList.add(RBACEnum.DEPARTMENT_UPDATED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }

    /**
     * This method is used for deleting department
     */
    @Delete("/deletedepartment/{id}")
    public MessageResponse deleteDepartment(@PathVariable("id") String id) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "deleteDepartment";
        departmentService.deleteDepartment(id);
        rbacLogger.logs(className, methodName, "Department deleted successfully");
        rbacEnumList.add(RBACEnum.DEPARTMENT_DELETED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }
}