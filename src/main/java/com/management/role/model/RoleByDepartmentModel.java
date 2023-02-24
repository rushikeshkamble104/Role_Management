package com.management.role.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * This class is an Entity model for role by department
 */
@Entity
@Table(name = "RoleByDepartment")
@RequiredArgsConstructor
@Data
public class RoleByDepartmentModel {

    @Id
    @Column(name = "RoleByDepartmentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleByDepartmentId;

    @ManyToOne
    private RoleModel roleModel;

    @ManyToOne
    private DepartmentModel departmentModel;

    @ManyToOne
    private SubDepartmentModel subDepartmentModel;


}
