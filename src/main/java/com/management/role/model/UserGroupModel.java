package com.management.role.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * This class is an Entity model for user group
 */
@Entity
@Table(name = "UserGroup")
@RequiredArgsConstructor
@Data
public class UserGroupModel {

    @Id
    @Column(name = "UserGroupId")
    private String userGroupId;

    @Column(name = "UserGroupName")
    private String userGroupName;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "userGroupModel")
    @JsonIgnore
    List<UserGroupRoleModel> userGroupRoleModels;
}
