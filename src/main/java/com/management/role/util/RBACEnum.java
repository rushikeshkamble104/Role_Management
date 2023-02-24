package com.management.role.util;

import io.micronaut.http.HttpStatus;

import static com.management.role.util.RBACUtility.*;

/**
 * This enum is a group of constants for user group
 */
public enum RBACEnum {

    /**
     * User Group Enum
     */
    ERROR_REQUEST_USER_GROUP_ID_IS_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request user group id is blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_USER_GROUP_ID_IS_INVALID(EAZ_400, "Bad-Request - Error request user group id is invalid", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_USER_GROUP_ID_ALREADY_EXISTS(EAZ_400, "Bad-Request - Error request user group id already exists", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_USER_GROUP_NAME_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request user group name blank or null", HttpStatus.BAD_REQUEST),
    USER_GROUP_VALIDATED_AND_ADDED_SUCCESSFULLY(EAZ_200, "Success - User group validated and added successfully", HttpStatus.OK),
    USER_GROUP_UPDATED_SUCCESSFULLY(EAZ_200, "Success - User group updated successfully", HttpStatus.OK),
    USER_GROUP_DELETED_SUCCESSFULLY(EAZ_200, "Success - User group deleted successfully", HttpStatus.OK),

    /**
     * Role Enum
     */
    ERROR_REQUEST_ROLE_ID_IS_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request role id is blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_ROLE_ID_IS_INVALID(EAZ_400, "Bad-Request - Error request role id is invalid", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_ROLE_ID_ALREADY_EXISTS(EAZ_400, "Bad-Request - Error request role id already exists", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_ROLE_NAME_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request role name blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_ROLE_DESCRIPTION_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request role description blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_ROLE_CREATED_DATE_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request created date blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_ROLE_CREATED_BY_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request created by blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_ROLE_UPDATED_DATE_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request updated date blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_ROLE_UPDATED_BY_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request updated by blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_IS_ACTIVE_IS_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request is active is blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_IS_ACTIVE_IS_INVALID(EAZ_400, "Bad-Request - Error request is active is invalid", HttpStatus.BAD_REQUEST),
    ROLE_VALIDATED_AND_ADDED_SUCCESSFULLY(EAZ_200, "Success - Role validated and added successfully", HttpStatus.OK),
    ROLE_UPDATED_SUCCESSFULLY(EAZ_200, "Success - Role updated successfully", HttpStatus.OK),
    ROLE_DELETED_SUCCESSFULLY(EAZ_200, "Success - Role deleted successfully", HttpStatus.OK),

    /**
     * Activity Enum
     */
    ERROR_REQUEST_ACTIVITY_ID_IS_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request activity id is blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_ACTIVITY_ID_IS_INVALID(EAZ_400, "Bad-Request - Error request activity id is invalid", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_ACTIVITY_ID_ALREADY_EXISTS(EAZ_400, "Bad-Request - Error request activity id already exists", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_ACTIVITY_NAME_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request activity name blank or null", HttpStatus.BAD_REQUEST),
    ACTIVITY_VALIDATED_AND_ADDED_SUCCESSFULLY(EAZ_200, "Success - Activity validated and added successfully", HttpStatus.OK),
    ACTIVITY_UPDATED_SUCCESSFULLY(EAZ_200, "Success - Activity updated successfully", HttpStatus.OK),
    ACTIVITY_DELETED_SUCCESSFULLY(EAZ_200, "Success - Activity deleted successfully", HttpStatus.OK),

    /**
     * Privilege Enum
     */
    ERROR_REQUEST_PRIVILEGE_ID_IS_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request privilege id is blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_PRIVILEGE_ID_IS_INVALID(EAZ_400, "Bad-Request - Error request privilege id is invalid", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_PRIVILEGE_ID_ALREADY_EXISTS(EAZ_400, "Bad-Request - Error request privilege id already exists", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_PRIVILEGE_NAME_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request privilege name blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_PRIVILEGE_DESCRIPTION_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request privilege description blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_PRIVILEGE_CREATED_BY_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request privilege created by blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_PRIVILEGE_CREATED_DATE_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request privilege created date blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_PRIVILEGE_UPDATED_BY_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request privilege updated by blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_PRIVILEGE_UPDATED_DATE_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request privilege updated date blank or null", HttpStatus.BAD_REQUEST),
    PRIVILEGE_VALIDATED_AND_ADDED_SUCCESSFULLY(EAZ_200, "Success - Privilege validated and added successfully", HttpStatus.OK),
    PRIVILEGE_UPDATED_SUCCESSFULLY(EAZ_200, "Success - Privilege updated successfully", HttpStatus.OK),
    PRIVILEGE_DELETED_SUCCESSFULLY(EAZ_200, "Success - Privilege deleted successfully", HttpStatus.OK),

    /**
     * Department Enum
     */
    ERROR_REQUEST_DEPARTMENT_ID_IS_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request department id is blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_DEPARTMENT_ID_IS_INVALID(EAZ_400, "Bad-Request - Error request department id is invalid", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_DEPARTMENT_ID_ALREADY_EXISTS(EAZ_400, "Bad-Request - Error request department id already exists", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_DEPARTMENT_NAME_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request department name blank or null", HttpStatus.BAD_REQUEST),
    DEPARTMENT_VALIDATED_AND_ADDED_SUCCESSFULLY(EAZ_200, "Success - Department validated and added successfully", HttpStatus.OK),
    DEPARTMENT_UPDATED_SUCCESSFULLY(EAZ_200, "Success - Department updated successfully", HttpStatus.OK),
    DEPARTMENT_DELETED_SUCCESSFULLY(EAZ_200, "Success - Department deleted successfully", HttpStatus.OK),

    /**
     * Department Enum
     */
    ERROR_REQUEST_SUB_DEPARTMENT_ID_IS_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request sub department id is blank or null", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_SUB_DEPARTMENT_ID_IS_INVALID(EAZ_400, "Bad-Request - Error request sub department id is invalid", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_SUB_DEPARTMENT_ID_ALREADY_EXISTS(EAZ_400, "Bad-Request - Error request sub department id already exists", HttpStatus.BAD_REQUEST),
    ERROR_REQUEST_SUB_DEPARTMENT_NAME_BLANK_OR_NULL(EAZ_400, "Bad-Request - Error request sub department name blank or null", HttpStatus.BAD_REQUEST),
    SUB_DEPARTMENT_VALIDATED_AND_ADDED_SUCCESSFULLY(EAZ_200, "Success - Sub department validated and added successfully", HttpStatus.OK),
    SUB_DEPARTMENT_UPDATED_SUCCESSFULLY(EAZ_200, "Success - Sub department updated successfully", HttpStatus.OK),
    SUB_DEPARTMENT_DELETED_SUCCESSFULLY(EAZ_200, "Success - Sub department deleted successfully", HttpStatus.OK);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    RBACEnum(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
