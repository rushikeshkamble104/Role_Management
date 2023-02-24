package com.management.role.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * This class is an Entity model for role
 */
@Entity
@Table(name = "Role")
@RequiredArgsConstructor
@Data
public class RoleModel {

    @Id
    @Column(name = "RoleId")
    private String roleId;

    @Column(name = "RoleName")
    private String roleName;

    @Column(name = "RoleDescription")
    private String roleDescription;

    @Column(name = "CreatedDate")
    private String createdDate;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "UpdatedDate")
    private String updatedDate;

    @Column(name = "UpdatedBy")
    private String updatedBy;

    @Column(name = "IsActive")
    private String isActive;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "roleModel")
    @JsonIgnore
    List<UserGroupRoleModel> userGroupRoleModels;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "roleModel")
    @JsonIgnore
    List<RoleActivityModel> roleActivityModels;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "roleModel")
    @JsonIgnore
    List<RoleByDepartmentModel> roleByDepartmentModels;
}