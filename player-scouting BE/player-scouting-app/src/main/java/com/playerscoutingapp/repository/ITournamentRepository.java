package com.playerscoutingapp.repository;

import com.playerscoutingapp.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */
@Repository
public interface ITournamentRepository extends JpaRepository<Tournament,Integer> {

}
