package com.playerscoutingapp.controllers;

import com.playerscoutingapp.model.Player;
import com.playerscoutingapp.model.Signing;
import com.playerscoutingapp.model.Team;
import com.playerscoutingapp.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Sheika Abuthair
 * @Date : 17-05-2022
 * @Project : assignmentProject
 */
@RestController
@RequestMapping("/team-api")
public class TeamController {
    //ITeamService is Autowired with setter method
    ITeamService iTeamService;
    @Autowired
    public void setiTeamService(ITeamService iTeamService) {
        this.iTeamService = iTeamService;
    }

    /**
     * @PostMapping this api call helps us to add team
     * @param team
     */
    @PostMapping("/admin/teams")
    ResponseEntity<Void> addTeam(@RequestBody Team team) {
        iTeamService.addTeam(team);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }

    /**
     * @PutMapping this api call helps us to update team
     * @param team
     */
    @PutMapping("/admin/teams")
    ResponseEntity<Void> updateTeam(@RequestBody Team team) {
        iTeamService.updateTeam(team);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return responseEntity;
    }

    /**
     * @DeleteMapping this api call helps us to delete team using teamId
     * @param teamId
     */
    @DeleteMapping("/admin/teams/teamId/{teamId}")
    ResponseEntity<Void> deleteTeam(@PathVariable("teamId") int teamId) {
        iTeamService.deleteTeam(teamId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "delete one team by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }

    /**
     * @GetMapping this api call helps us to get Team using teamId
     * @param TeamId
     */

    @GetMapping("/user/teams/teamId/{teamId}")
    ResponseEntity<Team> getById(@PathVariable("teamId") int TeamId) {
      Team team =  iTeamService.getById(TeamId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get one team by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(team);

    }

    /**
     * @GetMapping this api call helps us to get all teams
     */
    //http://localhost:8080/team-api/admin/teams
    @GetMapping("/admin/teams")
    ResponseEntity<List<Team>> getAll() {
        List<Team> teams = iTeamService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all teams");
        ResponseEntity<List<Team>>responseEntity= new ResponseEntity<>(teams,headers,HttpStatus.OK);
        return responseEntity;
    }
}