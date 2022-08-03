package com.playerscoutingapp.service;

import com.playerscoutingapp.exception.TournamentNotFoundException;
import com.playerscoutingapp.model.Tournament;
import com.playerscoutingapp.repository.ITournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */

@Service
public class TournamentServiceImpl implements  ITournamentService{
    /**
     * The @Autowired annotation can be used to autowire bean on the setter method
     */
    ITournamentRepository iTournamentRepository;
    @Autowired
    public void setiTournamentRepository(ITournamentRepository iTournamentRepository) {
        this.iTournamentRepository = iTournamentRepository;
    }

    /**
     * addTournament this method implementation will allow us to add tournament
     * @param tournament
     */
    @Override
    public void addTournament(Tournament tournament) {
        iTournamentRepository.save(tournament);
    }

    /**
     * updateTournament this method implementation will allow us to update tournament
     * @param tournament
     */
    @Override
    public void updateTournament(Tournament tournament) {
       iTournamentRepository.save(tournament);
    }

    /**
     * deleteTournament this method implementation will allow us to delete tournament using tournamentId
     * @param tournamentId
     */
    @Override
    public void deleteTournament(int tournamentId) {
     iTournamentRepository.deleteById(tournamentId);
    }

    /**
     *getById this method implementation will allow us to get tournament using tournamentId
     * @param tournamentId
     */
    @Override
    public Tournament getById(int tournamentId)throws TournamentNotFoundException {
       Tournament tournament = iTournamentRepository.findById(tournamentId).get();
       if (tournament==null){

       }
        return tournament;
    }

    /**
     *getAll this method implementation will allow us to get all tournaments
     * @return
     */
    @Override
    public List<Tournament> getAll() {

        return iTournamentRepository.findAll();
    }
}
