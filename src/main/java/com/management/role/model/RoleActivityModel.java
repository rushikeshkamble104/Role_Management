package com.management.role.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * This class is an Entity model for role activity
 */
@Entity
@Table(name = "RoleActivity")
@RequiredArgsConstructor
@Data
public class RoleActivityModel {

    @Id
    @Column(name = "RoleActivityId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleActivityId;

    @ManyToOne
    private RoleModel roleModel;

    @ManyToOne
    private ActivityModel activityModel;


}
