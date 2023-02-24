package com.management.role.service;

import com.management.role.model.ActivityPrivilegeModel;
import com.management.role.repository.ActivityPrivilegeRepository;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class ActivityPrivilegeServiceTest {

    @Inject
    ActivityPrivilegeService activityPrivilegeService;

    @Inject
    ActivityPrivilegeRepository activityPrivilegeRepository;

    @MockBean(ActivityPrivilegeRepository.class)
    ActivityPrivilegeRepository getActivityPrivilegeRepository() {
        return mock(ActivityPrivilegeRepository.class);
    }

    @Test
    void TestActivityPrivilegeService_success() {
        ActivityPrivilegeModel activityPrivilegeModel = new ActivityPrivilegeModel();
        activityPrivilegeModel.setActivityPrivilegeId(1);
        when(activityPrivilegeRepository.save(Mockito.any())).thenReturn(activityPrivilegeModel);
        ActivityPrivilegeModel save = activityPrivilegeService.saveActivityPrivilege(activityPrivilegeModel);
        assertNotNull(save);
    }


    @Test
    void TestGetActivityService() {
        List<ActivityPrivilegeModel> activityPrivilegeModels = new ArrayList<>();
        when(activityPrivilegeRepository.findAll()).thenReturn(activityPrivilegeModels);
        List<ActivityPrivilegeModel> get = activityPrivilegeService.getActivityPrivilege();
        assertNotNull(get);
    }
}
