package com.management.role.repository;

import com.management.role.model.DepartmentModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

/**
 * This interface is a repository for department
 */
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, String> {}