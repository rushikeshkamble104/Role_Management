package com.management.role.util;

import com.management.role.dto.Message;
import com.management.role.dto.MessageResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class RBACUtility {

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String EAZ_200 = "EAZ-200";
    public static final String EAZ_400 = "EAZ-400";
    private static final String PATTERN = "^\\d+$";

    private RBACUtility() {}

    /**
     * User group validations
     */
    public static boolean blankOrNullUserGroupId(String userGroupId) {
        return Objects.equals(userGroupId, "") || userGroupId == null;
    }

    public static boolean invalidUserGroupId(String userGroupId) {
        boolean isMatch = Pattern.compile(PATTERN).matcher(userGroupId).find();
        return !isMatch;
    }

    public static boolean blankOrNullUserGroupName(String userGroupName) {
        return Objects.equals(userGroupName, "") || userGroupName == null;
    }

    /**
     * Role validations
     */
    public static boolean blankOrNullRoleId(String roleId) {
        return Objects.equals(roleId, "") || roleId == null;
    }

    public static boolean invalidRoleId(String roleId) {
        boolean isMatch = Pattern.compile(PATTERN).matcher(roleId).find();
        return !isMatch;
    }

    public static boolean blankOrNullRoleName(String roleName) {
        return Objects.equals(roleName, "") || roleName == null;
    }

    public static boolean blankOrNullRoleDescription(String roleDescription) {
        return Objects.equals(roleDescription, "") || roleDescription == null;
    }

    public static boolean blankOrNullRoleCreatedDate(String createdDate) {
        return Objects.equals(createdDate, "") || createdDate == null;
    }

    public static boolean blankOrNullRoleCreatedBy(String createdBy) {
        return Objects.equals(createdBy, "") || createdBy == null;
    }

    public static boolean blankOrNullRoleUpdatedDate(String updatedDate) {
        return Objects.equals(updatedDate, "") || updatedDate == null;
    }

    public static boolean blankOrNullRoleUpdatedBy(String updatedBy) {
        return Objects.equals(updatedBy, "") || updatedBy == null;
    }

    public static boolean blankOrNullIsActive(String isActive) {
        return Objects.equals(isActive, "") || isActive == null;
    }

    public static boolean invalidIsActive(String isActive) {
        return !isActive.equals("true") && !isActive.equals("false");
    }

    /**
     * Activity validations
     */
    public static boolean blankOrNullActivityId(String activityId) {
        return Objects.equals(activityId, "") || activityId == null;
    }

    public static boolean invalidActivityId(String activityId) {
        boolean isMatch = Pattern.compile(PATTERN).matcher(activityId).find();
        return !isMatch;
    }

    public static boolean blankOrNullActivityName(String activityName) {
        return Objects.equals(activityName, "") || activityName == null;
    }

    /**
     * Privilege validations
     */
    public static boolean blankOrNullPrivilegeId(String privilegeId) {
        return Objects.equals(privilegeId, "") || privilegeId == null;
    }

    public static boolean invalidPrivilegeId(String privilegeId) {
        boolean isMatch = Pattern.compile(PATTERN).matcher(privilegeId).find();
        return !isMatch;
    }

    public static boolean blankOrNullPrivilegeName(String privilegeName) {
        return Objects.equals(privilegeName, "") || privilegeName == null;
    }

    public static boolean blankOrNullPrivilegeDescription(String description) {
        return Objects.equals(description, "") || description == null;
    }

    public static boolean blankOrNullPrivilegeCreatedBy(String createdBy) {
        return Objects.equals(createdBy, "") || createdBy == null;
    }

    public static boolean blankOrNullPrivilegeCreatedDate(String createdDate) {
        return Objects.equals(createdDate, "") || createdDate == null;
    }

    public static boolean blankOrNullPrivilegeUpdatedBy(String updatedBy) {
        return Objects.equals(updatedBy, "") || updatedBy == null;
    }

    public static boolean blankOrNullPrivilegeUpdatedDate(String updatedDate) {
        return Objects.equals(updatedDate, "") || updatedDate == null;
    }

    /**
     * Department validations
     */
    public static boolean blankOrNullDepartmentId(String departmentId) {
        return Objects.equals(departmentId, "") || departmentId == null;
    }

    public static boolean invalidDepartmentId(String departmentId) {
        boolean isMatch = Pattern.compile(PATTERN).matcher(departmentId).find();
        return !isMatch;
    }

    public static boolean blankOrNullDepartmentName(String departmentName) {
        return Objects.equals(departmentName, "") || departmentName == null;
    }

    /**
     * Sub department validations
     */
    public static boolean blankOrNullSubDepartmentId(String subDepartmentId) {
        return Objects.equals(subDepartmentId, "") || subDepartmentId == null;
    }

    public static boolean invalidSubDepartmentId(String subDepartmentId) {
        boolean isMatch = Pattern.compile(PATTERN).matcher(subDepartmentId).find();
        return !isMatch;
    }

    public static boolean blankOrNullSubDepartmentName(String subDepartmentName) {
        return Objects.equals(subDepartmentName, "") || subDepartmentName == null;
    }

    /**
     * This method is used for returning custom http response
     */
    public static MessageResponse addMessage(String status, List<RBACEnum> rbacEnumList) {

        final MessageResponse messageResponse = new MessageResponse();
        final List<Message> messages = new ArrayList<>();
        messageResponse.setStatus(status);
        for(RBACEnum anRBACEnum : rbacEnumList){
            messageResponse.setStatusCode(anRBACEnum.getHttpStatus().getCode());
            messageResponse.setCode(anRBACEnum.getCode());
            String message = anRBACEnum.getMessage();
            Message newMessage = new Message();
            newMessage.setMessages(message);
            messages.add(newMessage);
        }
        messageResponse.setMessages(messages);
        return messageResponse;
    }
}