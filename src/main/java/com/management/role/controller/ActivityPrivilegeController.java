package com.management.role.controller;

import com.management.role.model.ActivityPrivilegeModel;
import com.management.role.service.ActivityPrivilegeService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

/**
 * This class is a controller for activity privilege
 */
@Controller
public class ActivityPrivilegeController {

    @Inject
    private ActivityPrivilegeService activityPrivilegeService;

    /**
     * This method is used for saving activity privilege
     */
    @Post("/postactivityprivilege")
    public ActivityPrivilegeModel saveActivityPrivilege(@Body ActivityPrivilegeModel activityPrivilegeModel) {
        return activityPrivilegeService.saveActivityPrivilege(activityPrivilegeModel);
    }

    /**
     * This method is used for fetching all activity privileges
     */
    @Get("/getactivityprivilege")
    public List<ActivityPrivilegeModel> getActivityPrivilege() {
        return activityPrivilegeService.getActivityPrivilege();
    }
}
