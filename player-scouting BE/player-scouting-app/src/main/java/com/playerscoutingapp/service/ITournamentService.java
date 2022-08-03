package com.playerscoutingapp.service;

import com.playerscoutingapp.exception.TournamentNotFoundException;
import com.playerscoutingapp.model.Tournament;

import java.util.List;

/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */
public interface ITournamentService {
  /**
   * addTournament this method is used to add the tournament
   * @param tournament
   */
  void addTournament(Tournament tournament);

  /**
   * updateTournament this method is used to update the tournament
   * @param tournament
   */
  void updateTournament(Tournament tournament);

  /**
   * deleteTournament this method is used to delete the tournament using tournamentId
   * @param tournamentId
   */
  void deleteTournament(int tournamentId);

  /**
   * getById this method is used to get the tournament using tournamentId
   * @param tournamentId
   * @return
   */
  Tournament getById(int tournamentId)throws TournamentNotFoundException;

  /**
   *getAll this method is used to get all the tournaments
   */
  List<Tournament> getAll();
}
