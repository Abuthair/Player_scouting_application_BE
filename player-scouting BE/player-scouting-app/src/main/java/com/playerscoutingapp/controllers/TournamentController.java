package com.playerscoutingapp.controllers;

import com.playerscoutingapp.exception.TournamentNotFoundException;
import com.playerscoutingapp.model.Team;
import com.playerscoutingapp.model.Tournament;
import com.playerscoutingapp.service.ITournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sheika Abuthair
 * @Date : 17-05-2022
 * @Project : assignmentProject
 */
@RestController
@RequestMapping("/tournament-api")
public class TournamentController {
    //ITournamentService is Autowired using setter method
    ITournamentService iTournamentService;
    @Autowired
    public void setiTournamentService(ITournamentService iTournamentService) {
        this.iTournamentService = iTournamentService;
    }

    /**
     * @PostMapping this api call helps us to add tournament
     * @param tournament
     */
    @PostMapping("/admin/tournaments")
    ResponseEntity<Void> addTournament(@RequestBody Tournament tournament){
        iTournamentService.addTournament(tournament);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }

    /**
     * @PutMapping this api call helps us to update tournament
     * @param tournament
     */
    @PutMapping("/admin/tournaments")
    ResponseEntity <Void> updateTournament(@RequestBody Tournament tournament){
       iTournamentService.updateTournament(tournament);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return responseEntity;
    }

    /**
     * @DeleteMapping this api call helps us to delete tournament using tournamentId
     * @param tournamentId
     */
     @DeleteMapping("/admin/tournaments/tournamentId/{tournamentId}")
    ResponseEntity<Void> deleteTournament(@PathVariable("tournamentId") int tournamentId){
        iTournamentService.deleteTournament(tournamentId);
         HttpHeaders headers = new HttpHeaders();
         headers.add("desc", "delete one tournament by Id");
         return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    /**
     * @GetMapping this api call helps us to get tournament using tournamentId
     * @param tournamentId
     */
    @GetMapping("/user/tournaments/tournamentId/{tournamentId}")
    ResponseEntity<Tournament> getById(@PathVariable("tournamentId") int tournamentId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get one tournament by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }

    /**
     * @GetMapping this api call helps us to get All the tournaments
     */
    @GetMapping("/user/tournaments")
     ResponseEntity<List<Tournament>> getAll(){
        List<Tournament> tournaments = iTournamentService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all teams");
        ResponseEntity<List<Tournament>>responseEntity= new ResponseEntity<>(tournaments,headers,HttpStatus.OK);
        return responseEntity;
    }

}
