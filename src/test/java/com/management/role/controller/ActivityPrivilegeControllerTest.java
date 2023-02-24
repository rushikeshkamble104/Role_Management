package com.management.role.controller;


import com.management.role.model.ActivityPrivilegeModel;
import com.management.role.repository.ActivityPrivilegeRepository;
import com.management.role.service.ActivityPrivilegeService;
import com.management.role.service.ActivityService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
 class ActivityPrivilegeControllerTest {

    @Inject
    ActivityPrivilegeController activityPrivilegeController;

    @Inject
    ActivityPrivilegeService activityPrivilegeService;
    @Inject
    ActivityPrivilegeRepository activityPrivilegeRepository;

    @MockBean(ActivityPrivilegeService.class)
    ActivityPrivilegeService activityPrivilegeService(){return mock(ActivityPrivilegeService.class);}

    @Test
    void ActivityPrivilegeSave_success()
    {
        ActivityPrivilegeModel activityPrivilegeModel =new ActivityPrivilegeModel();
       when(activityPrivilegeService.saveActivityPrivilege(Mockito.any())).thenReturn(activityPrivilegeModel);
       activityPrivilegeController.saveActivityPrivilege(activityPrivilegeModel);
        assertNotNull(activityPrivilegeModel);
    }

    @Test
    void ActivityPrivilegeGet_success()
    {
        List<ActivityPrivilegeModel> activityPrivilegeModels = new ArrayList<>();
        when(activityPrivilegeService.getActivityPrivilege()).thenReturn(activityPrivilegeModels);
        List<ActivityPrivilegeModel> activityPrivilege = activityPrivilegeController.getActivityPrivilege();
        assertNotNull(activityPrivilege);
    }
}
