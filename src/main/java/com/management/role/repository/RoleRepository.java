package com.management.role.repository;

import com.management.role.model.RoleModel;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This interface is a repository for role
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleModel, String>
{
   // @Query("select " )
//   Query query = new Query( RoleModel.where(RoleName).is(value.toString()));
    //List<RoleModel> findRoleModelByRoleNameInIgnoreCase(List<String> roleName);

}