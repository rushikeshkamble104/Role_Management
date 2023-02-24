package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.SubDepartmentRequest;
import com.management.role.model.SubDepartmentModel;
import com.management.role.repository.SubDepartmentRepository;
import com.management.role.service.SubDepartmentService;
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
public class SubDepartmentController {

    @Inject
    RBACLogger rbacLogger;
    @Inject
    private SubDepartmentService subDepartmentService;
    @Inject
    private SubDepartmentRepository subDepartmentRepository;
    final String className = getClass().getSimpleName();

    /**
     * This method is used for saving sub department
     */
    @ReflectiveAccess
    @Post("/postsubdepartment")
    public MessageResponse saveSubDepartment(@Body SubDepartmentRequest subDepartmentRequest) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "saveSubDepartment";

        if (RBACUtility.blankOrNullSubDepartmentId(subDepartmentRequest.getSubDepartmentId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateSubDepartmentIdRequest :: subDepartmentModel.getSubDepartmentId object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_SUB_DEPARTMENT_ID_IS_BLANK_OR_NULL);
        }
        else if (RBACUtility.invalidSubDepartmentId(subDepartmentRequest.getSubDepartmentId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateSubDepartmentIdRequest :: subDepartmentModel.getSubDepartmentId object is invalid");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_SUB_DEPARTMENT_ID_IS_INVALID);
        }
        else if (subDepartmentRepository.existsById(subDepartmentRequest.getSubDepartmentId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateSubDepartmentIdRequest :: subDepartmentModel.getSubDepartmentId object is already present in database");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_SUB_DEPARTMENT_ID_ALREADY_EXISTS);
        }
        if (RBACUtility.blankOrNullSubDepartmentName(subDepartmentRequest.getSubDepartmentName())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateSubDepartmentNameRequest :: subDepartmentModel.getSubDepartmentName object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_SUB_DEPARTMENT_NAME_BLANK_OR_NULL);
        }
        if (!rbacEnumList.isEmpty()) return RBACUtility.addMessage(FAILURE, rbacEnumList);
        else {
            final SubDepartmentModel subDepartmentModel = new SubDepartmentModel();
            subDepartmentModel.setSubDepartmentId(subDepartmentRequest.getSubDepartmentId());
            subDepartmentModel.setSubDepartmentName(subDepartmentRequest.getSubDepartmentName());
            subDepartmentService.saveSubDepartment(subDepartmentModel);
            rbacLogger.logs(className, methodName, "Sub Department Validated and Added Successfully");
            rbacEnumList.add(RBACEnum.SUB_DEPARTMENT_VALIDATED_AND_ADDED_SUCCESSFULLY);
            return RBACUtility.addMessage(SUCCESS, rbacEnumList);
        }
    }

    /**
     * This method is used for fetching all sub departments
     */
    @Get("/getsubdepartment")
    public List<SubDepartmentModel> getSubDepartment() {
        return subDepartmentService.getSubDepartment();
    }

    /**
     * This method is used for updating sub department
     */
    @Put("/updatesubdepartment/{id}")
    public MessageResponse updateSubDepartment(@PathVariable String id, @Body SubDepartmentModel subDepartmentModel) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "updateSubDepartment";
        subDepartmentService.updateSubDepartment(id, subDepartmentModel);
        rbacLogger.logs(className, methodName, "Sub department updated successfully");
        rbacEnumList.add(RBACEnum.SUB_DEPARTMENT_UPDATED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }

    /**
     * This method is used for deleting sub department
     */
    @Delete("/deletesubdepartment/{id}")
    public MessageResponse deleteSubDepartment(@PathVariable("id") String id) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "deleteSubDepartment";
        subDepartmentService.deleteSubDepartment(id);
        rbacLogger.logs(className, methodName, "Sub department deleted successfully");
        rbacEnumList.add(RBACEnum.SUB_DEPARTMENT_DELETED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }
}