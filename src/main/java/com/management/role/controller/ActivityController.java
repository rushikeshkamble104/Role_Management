package com.management.role.controller;

import com.management.role.dto.MessageResponse;
import com.management.role.dto.request.ActivityRequest;
import com.management.role.model.ActivityModel;
import com.management.role.repository.ActivityRepository;
import com.management.role.service.ActivityService;
import com.management.role.util.RBACEnum;
import com.management.role.util.RBACLogger;
import com.management.role.util.RBACUtility;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static com.management.role.util.RBACUtility.FAILURE;
import static com.management.role.util.RBACUtility.SUCCESS;

/**
 * This class is a controller for activity
 */
@Controller
public class ActivityController {

    @Inject
    RBACLogger rbacLogger;
    @Inject
    private ActivityService activityService;
    @Inject
    private ActivityRepository activityRepository;

    final String className = getClass().getSimpleName();

    /**
     * This method is used for saving activity
     */
    @ReflectiveAccess
    @Post("/postactivity")
    public MessageResponse saveActivity(@Body ActivityRequest activityRequest) {

        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "saveActivity";

        if (RBACUtility.blankOrNullActivityId(activityRequest.getActivityId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateActivityIdRequest :: activityModel.getActivityId object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ACTIVITY_ID_IS_BLANK_OR_NULL);
        }
        else if (RBACUtility.invalidActivityId(activityRequest.getActivityId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateActivityIdRequest :: activityModel.getActivityId object is invalid");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ACTIVITY_ID_IS_INVALID);
        }
        else if (activityRepository.existsById(activityRequest.getActivityId())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateActivityIdRequest :: activityModel.getActivityId object is already present in database");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ACTIVITY_ID_ALREADY_EXISTS);
        }
        if (RBACUtility.blankOrNullActivityName(activityRequest.getActivityName())) {
            rbacLogger.logs(className, methodName, "EAZValidator.validateActivityNameRequest :: activityModel.getActivityName object is blank or null");
            rbacEnumList.add(RBACEnum.ERROR_REQUEST_ACTIVITY_NAME_BLANK_OR_NULL);
        }
        if (!rbacEnumList.isEmpty()) return RBACUtility.addMessage(FAILURE, rbacEnumList);
        else {
            final ActivityModel activityModel = new ActivityModel();
            activityModel.setActivityId(activityRequest.getActivityId());
            activityModel.setActivityName(activityRequest.getActivityName());
            activityService.saveActivity(activityModel);
            rbacLogger.logs(className, methodName, "Activity Validated and Added Successfully");
            rbacEnumList.add(RBACEnum.ACTIVITY_VALIDATED_AND_ADDED_SUCCESSFULLY);
            return RBACUtility.addMessage(SUCCESS, rbacEnumList);
        }
    }

    /**
     * This method is used for fetching all activities
     */
    @Get("/getactivity")
    public List<ActivityModel> getActivity() {
        return activityService.getActivity();
    }

    /**
     * This method is used for updating activity
     */
    @Put("/updateactivity/{id}")
    public MessageResponse updateActivity(@PathVariable String id, @Body ActivityModel activityModel) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "updateActivity";
        activityService.updateActivity(id, activityModel);
        rbacLogger.logs(className, methodName, "Activity updated successfully");
        rbacEnumList.add(RBACEnum.ACTIVITY_UPDATED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }

    /**
     * This method is used for deleting activity
     */
    @Delete("/deleteactivity/{id}")
    public MessageResponse deleteActivity(@PathVariable("id") String id) {
        final List<RBACEnum> rbacEnumList = new ArrayList<>();
        final String methodName = "deleteActivity";
        activityService.deleteActivity(id);
        rbacLogger.logs(className, methodName, "Activity deleted successfully");
        rbacEnumList.add(RBACEnum.ACTIVITY_DELETED_SUCCESSFULLY);
        return RBACUtility.addMessage(SUCCESS, rbacEnumList);
    }
}
