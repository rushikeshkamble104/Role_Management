package com.management.role.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.util.List;

/**
 * This class is an Entity model for privilege
 */
@Entity
@Table(name = "Privilege")
@RequiredArgsConstructor
@Data
public class PrivilegeModel {

    @Id
    @Column(name = "PrivilegeId")
    private String privilegeId;

    @Column(name = "PrivilegeName")
    private String privilegeName;

    @Column(name = "Description")
    private String description;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "CreatedDate")
    private String createdDate;

    @Column(name = "UpdatedBy")
    private String updatedBy;

    @Column(name = "UpdatedDate")
    private String updatedDate;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "privilegeModel")
    @JsonIgnore
    List<ActivityPrivilegeModel> activityPrivilegeModels;
}
