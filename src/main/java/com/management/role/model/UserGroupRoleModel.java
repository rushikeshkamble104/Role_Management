package com.management.role.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;

/**
 * This class is an Entity model for user group role
 */
@Entity
@Table(name = "UserGroupRole")
@RequiredArgsConstructor
@Data
public class UserGroupRoleModel {

    @Id
    @Column(name = "UserGroupRoleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userGroupRoleId;

    @ManyToOne
    private RoleModel roleModel;

    @ManyToOne
    private UserGroupModel userGroupModel;


}
