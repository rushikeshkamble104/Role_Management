package com.management.role.service;

import com.management.role.model.ActivityModel;
import com.management.role.repository.ActivityRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * This class is a service for activity
 */
@Singleton
public class ActivityService {

    @Inject
    private ActivityRepository activityRepository;

    /**
     * This method is used for saving an activity
     */
    public ActivityModel saveActivity(ActivityModel activityModel) {
        return activityRepository.save(activityModel);
    }

    /**
     * This method is used for fetching all activities
     */
    public List<ActivityModel> getActivity() {
        return activityRepository.findAll();
    }

    /**
     * This method is used for updating an activity
     */
    public ActivityModel updateActivity(String id, ActivityModel activityModel) {
        activityModel.setActivityId(id);
        return activityRepository.update(activityModel);
    }

    /**
     * This method is used for deleting an activity
     */
    public void deleteActivity(String id) {
        activityRepository.deleteById(id);
    }
}
