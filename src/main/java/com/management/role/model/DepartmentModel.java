package com.management.role.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.util.List;

/**
 * This class is an Entity model for department
 */
@Entity
@Table(name = "Department")
@RequiredArgsConstructor
@Data
public class DepartmentModel {

    @Id
    @Column(name = "DepartmentId")
    private String departmentId;

    @Column(name = "DepartmentName")
    private String departmentName;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "departmentModel")
    @JsonIgnore
    List<SubDepartmentModel> subDepartmentModels;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "departmentModel")
    @JsonIgnore
    List<RoleByDepartmentModel> roleByDepartmentModels;
}
