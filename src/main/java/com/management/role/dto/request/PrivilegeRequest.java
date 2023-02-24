package com.management.role.dto.request;

import lombok.Data;

@Data
public class PrivilegeRequest {

    private String privilegeId;
    private String privilegeName;
    private String description;
    private String createdBy;
    private String createdDate;
    private String updatedBy;
    private String updatedDate;
}
