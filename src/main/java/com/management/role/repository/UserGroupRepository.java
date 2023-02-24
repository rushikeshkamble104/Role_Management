package com.management.role.repository;

import com.management.role.model.UserGroupModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

/**
 * This interface is a repository for user group
 */
@Repository
public interface UserGroupRepository extends JpaRepository<UserGroupModel, String> {
}
