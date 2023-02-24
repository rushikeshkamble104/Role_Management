package com.management.role.service;

import com.management.role.model.ActivityModel;
import com.management.role.repository.ActivityRepository;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
 class ActivityServiceTest {

    @Inject
    ActivityService activityService;

    @Inject
    ActivityRepository activityRepository;

    @MockBean(ActivityRepository.class)
    ActivityRepository activityRepository(){return mock(ActivityRepository.class);}


    @Test
    void TestActivityService_success()
    {
        ActivityModel activitiesModel = new ActivityModel();
        activitiesModel.setActivityId("1");
        activitiesModel.setActivityName("rk");
        when(activityRepository.save(activitiesModel)).thenReturn(activitiesModel);
        ActivityModel save = activityService.saveActivity(activitiesModel);
        assertNotNull(save);
    }

    @Test
    void TestGetActivityService()
    {
        List<ActivityModel> activitiesModel = new ArrayList<ActivityModel>();
        when(activityRepository.findAll()).thenReturn(activitiesModel);
        List<ActivityModel> get = activityService.getActivity();
        assertNotNull(get);
    }
    @Test
    void TestUpdateActivityService()
    {
        ActivityModel activitiesModel = new ActivityModel();
        activitiesModel.setActivityId("1");
        activitiesModel.setActivityName("rk");
        when(activityRepository.update(activitiesModel)).thenReturn(activitiesModel);
        activityService.updateActivity(activitiesModel.getActivityId(),activitiesModel);
        assertNotNull(activitiesModel);
    }

    @Test
    void TestDeleteActivityService()
    {
        ActivityModel activitiesModel = new ActivityModel();
        activitiesModel.setActivityId("1");
        activitiesModel.setActivityName("rk");
        activityService.deleteActivity((activitiesModel.getActivityId()));

    }

}
