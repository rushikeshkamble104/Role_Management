package com.management.role.repository;

import com.management.role.model.RoleByDepartmentModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

/**
 * This interface is a repository for role by department
 */
@Repository
public interface RoleByDepartmentRepository extends JpaRepository<RoleByDepartmentModel, Integer> {}