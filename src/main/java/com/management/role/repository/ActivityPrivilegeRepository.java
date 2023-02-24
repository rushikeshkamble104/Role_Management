package com.management.role.repository;

import com.management.role.model.ActivityPrivilegeModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

/**
 * This interface is a repository for activity privilege
 */
@Repository
public interface ActivityPrivilegeRepository extends JpaRepository<ActivityPrivilegeModel, Integer> {}