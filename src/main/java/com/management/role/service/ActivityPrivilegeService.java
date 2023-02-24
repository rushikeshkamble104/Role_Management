package com.management.role.service;

import com.management.role.model.ActivityPrivilegeModel;
import com.management.role.repository.ActivityPrivilegeRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * This class is a service for activity privilege
 */
@Singleton
public class ActivityPrivilegeService {

    @Inject
    private ActivityPrivilegeRepository activityPrivilegeRepository;

    /**
     * This method is used for saving an activity privilege
     */
    public ActivityPrivilegeModel saveActivityPrivilege(ActivityPrivilegeModel activityPrivilegeModel) {
        return activityPrivilegeRepository.save(activityPrivilegeModel);
    }

    /**
     * This method is used for fetching all activity privileges
     */
    public List<ActivityPrivilegeModel> getActivityPrivilege() {
        return activityPrivilegeRepository.findAll();
    }
}
