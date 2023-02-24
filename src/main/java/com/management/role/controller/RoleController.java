package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.RoleRequest;
import com.management.role.model.RoleModel;
import com.management.role.repository.RoleRepository;
import com.management.role.service.RoleService;
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
 * This class is a controller for role
 */
@Controller
public class RoleController {


    @Inject
    RBACLogger rbacLogger;

    @Inject
    private RoleService roleService;

    @Inject
    private RoleRepository roleRepository;

    final String className = getClass().getSimpleName();

    /**
     * This method is used for saving role
     */
    @ReflectiveAccess
    @Post("/postrole")
    public MessageResponse saveRole(@Body RoleRequest roleRequest) {

        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "saveRole";

        //List<RoleModel> byRoleNameIn = roleRepository.findRoleModelByRoleNameInIgnoreCase(new ArrayList<>(List.of(new String[]{"Abc", "Wvd"})));
//        for(RoleModel roleModel:byRoleNameIn){
//            System.out.println(roleModel.getRoleName());
//        }

        if (RBACUtility.blankOrNullRoleId(roleRequest.getRoleId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateRoleIdRequest :: roleModel.getRoleId object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ROLE_ID_IS_BLANK_OR_NULL);
        }
        else if (RBACUtility.invalidRoleId(roleRequest.getRoleId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateRoleIdRequest :: roleModel.getRoleId object is invalid");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ROLE_ID_IS_INVALID);
        }
        else if (roleRepository.existsById(roleRequest.getRoleId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateRoleIdRequest :: roleModel.getRoleId object is already present in database");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ROLE_ID_ALREADY_EXISTS);
        }
        if (RBACUtility.blankOrNullRoleName(roleRequest.getRoleName())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateRoleNameRequest :: roleModel.getRoleName object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ROLE_NAME_BLANK_OR_NULL);
        }
        if (RBACUtility.blankOrNullRoleDescription(roleRequest.getRoleDescription())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateRoleDescriptionRequest :: roleModel.getRoleDescription object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ROLE_DESCRIPTION_BLANK_OR_NULL);
        }
        if (RBACUtility.blankOrNullRoleCreatedDate(roleRequest.getCreatedDate())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateCreatedDateRequest :: roleModel.getCreatedDate object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ROLE_CREATED_DATE_BLANK_OR_NULL);
        }
        if (RBACUtility.blankOrNullRoleCreatedBy(roleRequest.getCreatedBy())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateCreatedByRequest :: userGroupModel.getCreatedBy object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ROLE_CREATED_BY_BLANK_OR_NULL);
        }
        if (RBACUtility.blankOrNullRoleUpdatedDate(roleRequest.getUpdatedDate())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateCreatedByRequest :: roleModel.getUpdatedDate object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ROLE_UPDATED_DATE_BLANK_OR_NULL);
        }
        if (RBACUtility.blankOrNullRoleUpdatedBy(roleRequest.getUpdatedBy())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateUpdatedByRequest :: roleModel.getUpdatedBy object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ROLE_UPDATED_BY_BLANK_OR_NULL);
        }
        if (RBACUtility.blankOrNullIsActive(roleRequest.getIsActive())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateIsActiveRequest :: roleModel.getIsActive object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_IS_ACTIVE_IS_BLANK_OR_NULL);
        }
        else if (RBACUtility.invalidIsActive(roleRequest.getIsActive())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateIsActiveRequest :: roleModel.getIsActive object is invalid. It must be true or false ");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_IS_ACTIVE_IS_INVALID);
        }
        if (!rbacEnumList.isEmpty()) return RBACUtility.addMessage(FAILURE, rbacEnumList);
        else {
            final RoleModel roleModel = new RoleModel();
            roleModel.setRoleId(roleRequest.getRoleId());
            roleModel.setRoleName(roleRequest.getRoleName());
            roleModel.setRoleDescription(roleRequest.getRoleDescription());
            roleModel.setCreatedDate(roleRequest.getCreatedDate());
            roleModel.setCreatedBy(roleRequest.getCreatedBy());
            roleModel.setUpdatedDate(roleRequest.getUpdatedDate());
            roleModel.setUpdatedBy(roleRequest.getUpdatedBy());
            roleModel.setIsActive(roleRequest.getIsActive());
            roleService.saveRole(roleModel);
            rbacLogger.logs(className, methodName, "Role Validated and Added Successfully");
            rbacEnumList.add(RBACEnum.ROLE_VALIDATED_AND_ADDED_SUCCESSFULLY);
            return RBACUtility.addMessage(SUCCESS, rbacEnumList);
        }
    }

    /**
     * This method is used for fetching all roles
     */
    @Get("/getrole")
    public List<RoleModel> getRole() {
        return roleService.getRole();
    }

    /**
     * This method is used for updating role
     */
    @Put("/updaterole/{id}")
    public MessageResponse updateRole(@PathVariable String id, @Body RoleModel roleModel) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "updateRole";
        roleService.updateRole(id, roleModel);
        rbacLogger.logs(className, methodName, "Role updated successfully");
        rbacEnumList.add(RBACEnum.ROLE_UPDATED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }

    /**
     * This method is used for deleting role
     */
    @Delete("/deleterole/{id}")
    public MessageResponse deleteRole(@PathVariable("id") String id) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "deleteRole";
        roleService.deleteRole(id);
        rbacLogger.logs(className, methodName, "Role deleted successfully");
        rbacEnumList.add(RBACEnum.ROLE_DELETED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }
}