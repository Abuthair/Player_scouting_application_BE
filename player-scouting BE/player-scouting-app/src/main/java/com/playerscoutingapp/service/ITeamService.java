package com.playerscoutingapp.service;

import com.playerscoutingapp.exception.TeamNotFoundException;
import com.playerscoutingapp.model.Team;

import java.util.List;

/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */
public interface ITeamService {
    /**
     * addTeam this method used to add team
     * @param team
     */
    void addTeam(Team team);

    /**
     * updateTeam this method is used to update team
     * @param team
     */
    void updateTeam(Team team);

    /**
     * deleteteam this method is used to delete team using teamId
     * @param teamId
     */
    void deleteTeam(int teamId);

    /**
     * getById this method is used to get the team using teamId
     * @param TeamId
     */
    Team getById(int TeamId)throws TeamNotFoundException;

    /**
     *
     * gellAll this method is used to get all the teams
     */
    List<Team> getAll();
}
