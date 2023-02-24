package com.management.role.repository;

import com.management.role.model.PrivilegeModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

/**
 * This interface is a repository for privilege
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<PrivilegeModel, String> {}