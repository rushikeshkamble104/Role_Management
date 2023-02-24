package com.management.role.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * This class is an Entity model for sub department
 */
@Entity
@Table(name = "SubDepartment")
@RequiredArgsConstructor
@Data
public class SubDepartmentModel {

    @Id
    @Column(name = "SubDepartmentId")
    private String subDepartmentId;

    @Column(name = "SubDepartmentName")
    private String subDepartmentName;

    @ManyToOne
    private DepartmentModel departmentModel;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "departmentModel")
    @JsonIgnore
    List<RoleByDepartmentModel> roleByDepartmentModels;


}
