package com.management.role.dto.request;

import lombok.Data;

@Data
public class RoleRequest {

    private String roleId;
    private String roleName;
    private String roleDescription;
    private String createdDate;
    private String createdBy;
    private String updatedDate;
    private String updatedBy;
    private String isActive;
}
