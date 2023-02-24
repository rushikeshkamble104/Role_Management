package com.management.role.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * This class is an Entity model for activity
 */
@Entity
@Table(name = "Activity")
@RequiredArgsConstructor
@Data
public class ActivityModel {

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "activityModel")
    @JsonIgnore
    List<RoleActivityModel> roleActivityModels;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "activityModel")
    @JsonIgnore
    List<ActivityPrivilegeModel> activityPrivilegeModels;
    @Id
    @Column(name = "ActivityId")
    private String activityId;
    @Column(name = "ActivityName")
    private String activityName;
}