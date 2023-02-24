package com.management.role.repository;

import com.management.role.model.ActivityModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

/**
 * This interface is a repository for activity
 */
@Repository
public interface ActivityRepository extends JpaRepository<ActivityModel, String> {}