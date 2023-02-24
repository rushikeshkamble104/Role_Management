package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.PrivilegeRequest;
import com.management.role.model.ActivityModel;
import com.management.role.model.PrivilegeModel;
import com.management.role.repository.PrivilegeRepository;
import com.management.role.service.PrivilegeService;
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
 * This class is a controller for privilege
 */
@Controller
public class PrivilegeController {

    @Inject
    RBACLogger rbacLogger;
    @Inject
    private PrivilegeService privilegeService;
    @Inject
    private PrivilegeRepository privilegeRepository;
    final String className = getClass().getSimpleName();

    /**
     * This method is used for saving privilege
     */
    @ReflectiveAccess
    @Post("/postprivilege")
    public MessageResponse savePrivilege(@Body PrivilegeRequest privilegeRequest) {

        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "savePrivilege";

        if (RBACUtility.blankOrNullPrivilegeId(privilegeRequest.getPrivilegeId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validatePrivilegeIdRequest :: privilegeModel.getPrivilegeId object is null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_PRIVILEGE_ID_IS_BLANK_OR_NULL);
        }
        else if (RBACUtility.invalidPrivilegeId(privilegeRequest.getPrivilegeId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validatePrivilegeIdRequest :: privilegeModel.getPrivilegeId object is blank or invalid");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_PRIVILEGE_ID_IS_INVALID);
        }
        else if (privilegeRepository.existsById(privilegeRequest.getPrivilegeId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validatePrivilegeIdRequest :: privilegeModel.getPrivilegeId object is already present in database");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_PRIVILEGE_ID_ALREADY_EXISTS);
        }
        if (RBACUtility.blankOrNullPrivilegeName(privilegeRequest.getPrivilegeName())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validatePrivilegeNameRequest :: privilegeModel.getPrivilegeName object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_PRIVILEGE_NAME_BLANK_OR_NULL);
        }
        if (RBACUtility.blankOrNullPrivilegeDescription(privilegeRequest.getDescription())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateDescriptionRequest :: privilegeModel.getDescription object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_PRIVILEGE_DESCRIPTION_BLANK_OR_NULL);
        }
        if (RBACUtility.blankOrNullPrivilegeCreatedBy(privilegeRequest.getCreatedBy())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateCreatedByRequest :: privilegeModel.getCreatedBy object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_PRIVILEGE_CREATED_BY_BLANK_OR_NULL);
        }
        if (RBACUtility.blankOrNullPrivilegeCreatedDate(privilegeRequest.getCreatedDate())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateCreatedDateRequest :: privilegeModel.getCreatedDate object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_PRIVILEGE_CREATED_DATE_BLANK_OR_NULL);
        }
        if (RBACUtility.blankOrNullPrivilegeUpdatedBy(privilegeRequest.getUpdatedBy())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateUpdatedByRequest :: privilegeModel.getUpdatedBy object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_PRIVILEGE_UPDATED_BY_BLANK_OR_NULL);
        }
        if (RBACUtility.blankOrNullPrivilegeUpdatedDate(privilegeRequest.getUpdatedDate())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateUpdatedDateRequest :: privilegeModel.getUpdatedDate object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_PRIVILEGE_UPDATED_DATE_BLANK_OR_NULL);
        }
        if (!rbacEnumList.isEmpty()) return RBACUtility.addMessage(FAILURE, rbacEnumList);
        else {
            final PrivilegeModel privilegeModel = new PrivilegeModel();
            privilegeModel.setPrivilegeId(privilegeRequest.getPrivilegeId());
            privilegeModel.setPrivilegeName(privilegeRequest.getPrivilegeName());
            privilegeModel.setDescription(privilegeRequest.getDescription());
            privilegeModel.setCreatedBy(privilegeRequest.getCreatedBy());
            privilegeModel.setCreatedDate(privilegeRequest.getCreatedDate());
            privilegeModel.setUpdatedBy(privilegeRequest.getUpdatedBy());
            privilegeModel.setUpdatedDate(privilegeRequest.getUpdatedDate());
            privilegeService.savePrivilege(privilegeModel);
            rbacLogger.logs(className, methodName, "Privilege Validated and Added Successfully");
            rbacEnumList.add(RBACEnum.PRIVILEGE_VALIDATED_AND_ADDED_SUCCESSFULLY);
            return RBACUtility.addMessage(SUCCESS, rbacEnumList);
        }
    }

    /**
     * This method is used for fetching all privileges
     */
    @Get("/getprivilege")
    public List<PrivilegeModel> getPrivilege() {
        return privilegeService.getPrivilege();
    }

    /**
     * This method is used for updating privilege
     */
    @Put("/updateprivilege/{id}")
    public MessageResponse updatePrivilege(@PathVariable String id, @Body PrivilegeModel privilegeModel) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "updatePrivilege";
        privilegeService.updatePrivilege(id, privilegeModel);
        rbacLogger.logs(className, methodName, "Privilege updated successfully");
        rbacEnumList.add(RBACEnum.PRIVILEGE_UPDATED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }

    /**
     * This method is used for deleting privilege
     */
    @Delete("/deleteprivilege/{id}")
    public MessageResponse deletePrivilege(@PathVariable("id") String id) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "deletePrivilege";
        privilegeService.deletePrivilege(id);
        rbacLogger.logs(className, methodName, "Privilege deleted successfully");
        rbacEnumList.add(RBACEnum.PRIVILEGE_DELETED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }
}
