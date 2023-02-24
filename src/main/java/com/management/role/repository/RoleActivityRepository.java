package com.management.role.repository;

import com.management.role.model.RoleActivityModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

/**
 * This interface is a repository for role activity
 */
@Repository
public interface RoleActivityRepository extends JpaRepository<RoleActivityModel, Integer> {}