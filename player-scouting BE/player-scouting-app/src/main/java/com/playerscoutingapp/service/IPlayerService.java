package com.playerscoutingapp.service;

import com.playerscoutingapp.exception.PlayerNotFoundException;
import com.playerscoutingapp.exception.TeamNotFoundException;
import com.playerscoutingapp.exception.TournamentNotFoundException;
import com.playerscoutingapp.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */


public interface IPlayerService {
    /**
     *
     * addPlayer this method is used to add players
     * @param player
     */
    void addPlayer(Player player);

    /**
     *
     * updatePlayer this method is used to Update player
     * @param player
     */
    void updatePlayer(Player player);

    /**
     *
     * deletePlayer this method is used to delete the Player using playerId
     * @param playerId
     */
    void deletePlayer(int playerId);

    /**
     * getByPlayerId this method is used to get the player by playerId
     * @param playerId
     * @throws PlayerNotFoundException
     */
    Player getByPlayerId (int playerId) throws PlayerNotFoundException;

    /**
     *
     *getAll this method is used to get all the players
     */
    List<Player> getAll();

    /**
     * getByName this method is used to get the players using Name
     * @param playerName
     * @throws PlayerNotFoundException
     */
    List<Player> getByPlayerNameStartingWith(String playerName)throws  PlayerNotFoundException;

    /**
     * getByAge this method is used to get the players using age
     * @param age
     * @throws PlayerNotFoundException
     */
    List<Player> getByAge(int age) throws PlayerNotFoundException;

    /**
     * getByCountry this method is used to get the players using country
     * @param country
     * @throws PlayerNotFoundException
     */
    List<Player> getByCountry(String country) throws PlayerNotFoundException;

    /**
     * getByBatting this method is used to get the players using batting
     * @param batting
     * @throws PlayerNotFoundException
     */
    List<Player> getByBatting(String batting) throws PlayerNotFoundException;

    /**
     * getByBowling this method is used to get the players using bowling
     * @param bowling
     * @throws PlayerNotFoundException
     */

    List<Player> getByBowling(String bowling) throws PlayerNotFoundException;

    /**
     * getBySpecialist this method is used to get the players using specialist
     * @param specialist
     * @throws PlayerNotFoundException
     */
    List<Player> getBySpecialist(String specialist) throws PlayerNotFoundException;

    /**
     * getByStateTeam this method is used to get the players using stateTeam
     * @param StateTeam
     * @throws PlayerNotFoundException
     */
    List<Player> getByStateTeam(String StateTeam) throws PlayerNotFoundException;

    /**
     * getByTeamName this method is used to get the team using teamName
     * @param teamName
     * @throws TeamNotFoundException
     */
    List<Player> getByTeamName(String teamName) throws TeamNotFoundException;

    /**
     * getByTeamCity this method is used to get the team using teamCity
     * @param city
     * @throws TeamNotFoundException
     */
    List<Player> getByTeamCity(String city) throws TeamNotFoundException;

    /**
     * getByTeamTrophies this method is used to get the teams using trophies
     * @param trophies
     * @throws TeamNotFoundException
     */
    List<Player> getByTeamTrophies(String trophies) throws TeamNotFoundException;



    /**
     * getByNameCountry this method is used to get the players using name and country
     * @param name
     * @param country
     * @throws PlayerNotFoundException
     */
    List<Player> getByNameCountryStartingWith(String name, String country) throws PlayerNotFoundException;

    /**
     * getByBattingBowling this method is used to get the players using batting and bowling
     * @param batting
     * @param bowling
     * @throws PlayerNotFoundException
     */

    List<Player> getByBattingBowling(String batting, String bowling) throws PlayerNotFoundException;

    /**
     * getByPriceBetween this method is used to get the players with basePrice between  basePrice1 and basePrice2
     * @param basePrice1
     * @param basePrice2
     * @throws PlayerNotFoundException
     */
    List<Player> getByPriceBetween(double basePrice1,double basePrice2) throws PlayerNotFoundException;

    /**
     * getByPriceBetweenBatting this method is used to get the players  with basePrice between basePrice1 and base 2 with batting
     * @param basePrice1
     * @param basePrice2
     * @param batting
     * @throws PlayerNotFoundException
     */
    List<Player> getByPriceBetweenBatting(double basePrice1,double basePrice2,String batting)throws PlayerNotFoundException;

    /**
     * getByPriceBetweenBowling this method is used to get the players with basePrice between basePrice1 and basePrice2 with bowling
     * @param basePrice1
     * @param basePrice2
     * @param bowling
     * @throws PlayerNotFoundException
     */
    List<Player> getByPriceBetweenBowling(double basePrice1,double basePrice2,String bowling)throws PlayerNotFoundException;

    /**
     * getByTournamentName this method is used to get players using tournamentName
     * @param tournamentName
     * @throws TournamentNotFoundException
     */
    List<Player> getByTournamentName(String tournamentName)throws TournamentNotFoundException;

    /**
     * GetBYTournamentFormate this method is used to get players using tournamentFormate
     * @param tournamentFormat
     * @throws TournamentNotFoundException
     */
    List<Player> getTournamentFormat(String tournamentFormat)throws TournamentNotFoundException;
}