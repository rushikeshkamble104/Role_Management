package com.management.role.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * This class is an Entity model for activity privilege
 */
@Entity
@Table(name = "ActivityPrivilege")
@RequiredArgsConstructor
@Data
public class ActivityPrivilegeModel {

    @Id
    @Column(name = "ActivityPrivilegeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int activityPrivilegeId;

    @ManyToOne
    private ActivityModel activityModel;

    @ManyToOne
    private PrivilegeModel privilegeModel;


}