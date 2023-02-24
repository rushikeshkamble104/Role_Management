package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.ActivityRequest;
import com.management.role.model.ActivityModel;
import com.management.role.repository.ActivityRepository;
import com.management.role.service.ActivityService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
 class ActivityControllerTest {

    @Inject
    ActivityController activityController;

    @Inject
    ActivityService activityService;

    @Inject
    ActivityRepository activityRepository;

    @MockBean(ActivityService.class)
    ActivityService activitiesService(){return mock(ActivityService.class);}

    @MockBean(ActivityRepository.class)
    ActivityRepository activityRepository(){return mock(ActivityRepository.class);}

    @Test
    void testGetActivitiesController(){
        List<ActivityModel> activityModelList = new ArrayList<>();
        when(activitiesService().getActivity()).thenReturn(activityModelList);
        List<ActivityModel> activityModels  = activityController.getActivity();
        assertNotNull(activityModels);
    }

    @Test
    void testActivities_Activities_Null_failure (){
        ActivityRequest activityRequest = new ActivityRequest();
        MessageResponse messageResponse = activityController.saveActivity(activityRequest);
        assertEquals("failure",messageResponse.getStatus());
    }

    @Test
    void testSaveActivities_ActivitiesId_BlankOrNull_failure(){
        ActivityRequest activityRequest = new ActivityRequest();
        activityRequest.setActivityId("friend");
        activityRequest.setActivityName("idfc");
        MessageResponse messageResponse = activityController.saveActivity(activityRequest);
        assertEquals("failure",messageResponse.getStatus());
    }
    @Test
    void testSaveActivities_IdAlreadyExists_failure(){
        ActivityRequest activityRequest = new ActivityRequest();
        activityRequest.setActivityId("1");
        activityRequest.setActivityName("maker checker");
        when(activityRepository.existsById(Mockito.anyString())).thenReturn(true);
        MessageResponse messageResponse = activityController.saveActivity(activityRequest);
        assertEquals("failure",messageResponse.getStatus());
    }

    @Test
    void testSaveActivities_NameBlankOrNull_failure(){
        ActivityRequest activityRequest = new ActivityRequest();
        activityRequest.setActivityId("1");
        when(activityRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = activityController.saveActivity(activityRequest);
        assertEquals("failure",messageResponse.getStatus());
    }

    @Test
    void testSaveActivities_success(){
        ActivityRequest activityRequest = new ActivityRequest();
        activityRequest.setActivityId("1");
        activityRequest.setActivityName("maker checker");
        when(activityRepository.existsById(Mockito.anyString())).thenReturn(false);
        MessageResponse messageResponse = activityController.saveActivity(activityRequest);
        assertEquals("success",messageResponse.getStatus());
    }


    @Test
    void testUpdateActivity() {
        ActivityModel activitiesModel = new ActivityModel();
        when(activityService.updateActivity(activitiesModel.getActivityId(),activitiesModel)).thenReturn(activitiesModel);
        MessageResponse messageResponse = activityController.updateActivity(activitiesModel.getActivityId(),activitiesModel);
        assertEquals("success",messageResponse.getStatus());
    }

    @Test
    void testDeleteActivity() {
        ActivityModel activitiesModel = new ActivityModel();
        doNothing().when(activityService).deleteActivity(activitiesModel.getActivityId());
        MessageResponse messageResponse = activityController.deleteActivity(activitiesModel.getActivityId());
        assertEquals("success",messageResponse.getStatus());
    }
}
