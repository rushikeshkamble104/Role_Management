package com.management.role.repository;

import com.management.role.model.SubDepartmentModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

/**
 * This interface is a repository for sub department
 */
@Repository
public interface SubDepartmentRepository extends JpaRepository<SubDepartmentModel, String> {}