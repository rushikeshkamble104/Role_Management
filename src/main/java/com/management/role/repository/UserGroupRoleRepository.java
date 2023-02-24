package com.management.role.repository;

import com.management.role.model.UserGroupRoleModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

/**
 * This interface is a repository for user group role
 */
@Repository
public interface UserGroupRoleRepository extends JpaRepository<UserGroupRoleModel, Integer> {}