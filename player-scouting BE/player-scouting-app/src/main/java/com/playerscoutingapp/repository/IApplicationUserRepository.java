package com.playerscoutingapp.repository;

import com.playerscoutingapp.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sheika Abuthair
 * @Date : 20-05-2022
 * @Project : assignmentProject
 */

@Repository
public interface IApplicationUserRepository extends JpaRepository<ApplicationUser,Integer> {
    ApplicationUser findByUsername(String username);


}
