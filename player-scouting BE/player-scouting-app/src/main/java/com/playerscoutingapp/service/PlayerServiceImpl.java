package com.playerscoutingapp.service;

import com.playerscoutingapp.exception.PlayerNotFoundException;
import com.playerscoutingapp.exception.TeamNotFoundException;
import com.playerscoutingapp.exception.TournamentNotFoundException;
import com.playerscoutingapp.model.Player;
import com.playerscoutingapp.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */
@Service
public class PlayerServiceImpl  implements  IPlayerService{

    /**
     *  The @Autowired annotation can be used to autowire bean on the setter method
     */
    IPlayerRepository iPlayerRepository;
    @Autowired
    public void setiPlayerRepository(IPlayerRepository iPlayerRepository) {
        this.iPlayerRepository = iPlayerRepository;
    }
    /**
     * addPlayer this method implementation will allow us  to add players
     * @param player
     */

    @Override
    public void addPlayer(Player player) {
        iPlayerRepository.save(player);
    }

    /**
     * updatePlayer this method implementation will allow us to update Players
     * @param player
     */
    @Override
    public void updatePlayer(Player player) {
     iPlayerRepository.save(player);
    }

    /**
     * deletePlayer this method implementation will allow us to delete player using playerId
     * @param playerId
     */
    @Override
    public void deletePlayer(int playerId) {
     iPlayerRepository.deleteById(playerId);
    }

    /**
     * getByPlayerId this method implementation will allow us to find the player using playerId
     * @param playerId
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public Player getByPlayerId(int playerId) throws PlayerNotFoundException {
        Player players = iPlayerRepository.findById(playerId).get();
        if (players==null){
            throw new PlayerNotFoundException("Player Not Found");
        }
        return players ;
    }

    /**
     * getAll this method implementation will allow us to get All Players
     * @return All
     */
    @Override
    public List<Player> getAll() {
        return iPlayerRepository.findAll();
    }

    /**
     * getByName this method implementation will allow us to get player using playerName
     * @param playerName
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getByPlayerNameStartingWith(String playerName) throws PlayerNotFoundException {
        List<Player> players =iPlayerRepository.findByPlayerNameStartingWith(playerName);
        if (players.isEmpty()){
            throw new PlayerNotFoundException("Player Not Found");
        }
        return players;
    }

    /**
     * getByAge this method implementation will allow us to get players using age
     * @param age
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getByAge(int age) throws PlayerNotFoundException {
        List<Player> players = iPlayerRepository.findByAge(age);
        if (players==null){
            throw new PlayerNotFoundException("Player Not Found");
        }
        return players;
    }

    /**
     * getByCountry this method implementation will allow us to get players using country
     * @param country
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getByCountry(String country) throws PlayerNotFoundException {
        List<Player> players = iPlayerRepository.findByCountry(country);
        if (players.isEmpty()){
            throw new PlayerNotFoundException("Player Not Found");
        }
        return players;
    }

    /**
     * getByBatting this method implementation will allow us to get players using batting
     * @param batting
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getByBatting(String batting) throws PlayerNotFoundException {
       List<Player> players = iPlayerRepository.findByBatting(batting);
       if (players.isEmpty()){
           throw new PlayerNotFoundException("Player Not Found");
       }

       return players;
    }

    /**
     * getByBowling this method implementation will allow us to get players using bowling
     * @param bowling
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getByBowling(String bowling) throws PlayerNotFoundException {
        List<Player> players =iPlayerRepository.findByBowling(bowling);
        if (players.isEmpty()){
            throw  new PlayerNotFoundException("Player Not Found");
        }
        return players;
    }

    /**
     * getBySpecialist this method implementation will allow us to get players using specialist
     * @param specialist
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getBySpecialist(String specialist) throws PlayerNotFoundException {
       List<Player> players = iPlayerRepository.findBySpecialist(specialist);
       if (players.isEmpty()){
           throw  new PlayerNotFoundException("Player Not Found");
       }
        return players ;
    }

    /**
     * getByStateTeam this method implementation will allow us to get players using stateTeam
     * @param StateTeam
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getByStateTeam(String StateTeam) throws PlayerNotFoundException {
       List<Player> players = iPlayerRepository.findByStateTeam(StateTeam);
      if (players.isEmpty()){
          throw new PlayerNotFoundException("Player Not Found");
      }
        return players;
    }

    /**
     * getByTeamName this method implementation will allow us to get team using teamName
     * @param teamName
     * @return players
     * @throws TeamNotFoundException
     */
    @Override
    public List<Player> getByTeamName(String teamName) throws TeamNotFoundException {
       List<Player> players = iPlayerRepository.findByTeamName(teamName);
       if (players.isEmpty()){
           throw new TeamNotFoundException("Team Not Found");
       }
        return players;
    }

    /**
     * getByTeamCity this method implementation will allow us to get team using city
     * @param city
     * @return players
     * @throws TeamNotFoundException
     */
    @Override
    public List<Player> getByTeamCity(String city) throws TeamNotFoundException {
       List<Player> players = iPlayerRepository.findByTeamCity(city);
       if (players.isEmpty()){
           throw new TeamNotFoundException("Team City Not Found");
       }
        return players;
    }

    /**
     * getByTeamTrophies this method implementation will allow us to get team using trophies
     * @param trophies
     * @return players
     * @throws TeamNotFoundException
     */
    @Override
    public List<Player> getByTeamTrophies(String trophies) throws TeamNotFoundException {
        List<Player> players = iPlayerRepository.findByTeamTrophies(trophies);
        if (players.isEmpty()){

        }
        return players;
    }


    /**
     * getByNameCountry this method implementation will allow us to get player using name and country
     * @param name
     * @param country
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getByNameCountryStartingWith(String name, String country) throws PlayerNotFoundException {
      List<Player> players =iPlayerRepository.findByNameCountryStartingWith("%"+name+"%",country);
      if (players.isEmpty()){
          throw new PlayerNotFoundException("Player Not Found");
      }
        return players;
    }

    /**
     * getByBattingBowling this method implementation will allow us to get player using batting and bowling
     * @param batting
     * @param bowling
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getByBattingBowling(String batting, String bowling) throws PlayerNotFoundException {
        List<Player> players = iPlayerRepository.findByBattingBowling(batting,bowling);
        if (players.isEmpty()){
            throw new PlayerNotFoundException("Player Not Found");
        }
        return players ;
    }

    /**
     * getByPriceBetween this method implementation will allow us to get player price between basePrice1 and basePrice2
     * @param basePrice1
     * @param basePrice2
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getByPriceBetween(double basePrice1, double basePrice2) throws PlayerNotFoundException {
        List<Player> players = iPlayerRepository.findByPriceBetween(basePrice1,basePrice2);
        if (players.isEmpty()){
            throw new PlayerNotFoundException("Player Not Found");
        }
        return players;
    }
    /**
     * getByPriceBetween this method implementation will allow us to get player price between basePrice1 and basePrice2 with batting
     * @param basePrice1
     * @param basePrice2
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getByPriceBetweenBatting(double basePrice1, double basePrice2, String batting) throws PlayerNotFoundException {
        List<Player> players = iPlayerRepository.findByPriceBetweenBatting(basePrice1, basePrice2, batting);
        if (players.isEmpty()){
            throw new PlayerNotFoundException("Player Not found ");
        }
        return players;
    }
    /**
     * getByPriceBetween this method implementation will allow us to get player price between basePrice1 and basePrice2 with bowling
     * @param basePrice1
     * @param basePrice2
     * @return players
     * @throws PlayerNotFoundException
     */
    @Override
    public List<Player> getByPriceBetweenBowling(double basePrice1, double basePrice2, String bowling) throws PlayerNotFoundException {
       List<Player> players = iPlayerRepository.findByPriceBetweenBowling(basePrice1, basePrice2, bowling);
        if (players.isEmpty()){
            throw new PlayerNotFoundException("Player Not found ");
        }
        return players;
    }

    /**
     * getByTournamentName this method implementation will allow us to get player using tournament Name
     * @param tournamentName
     * @throws TournamentNotFoundException
     */
    @Override
    public List<Player> getByTournamentName(String tournamentName) throws TournamentNotFoundException {
       List<Player> players =iPlayerRepository.findByTournamentName(tournamentName);
       if (players.isEmpty()){
           throw new TournamentNotFoundException("tournament name not found");
       }
        return players;
    }

    /**
     * getTournamentFormat this method implementation will allow us to get player using tournament Format
     * @param tournamentFormat
     * @throws TournamentNotFoundException
     */
    @Override
    public List<Player> getTournamentFormat(String tournamentFormat) throws TournamentNotFoundException {
       List<Player> players =iPlayerRepository.findTournamentFormat(tournamentFormat);
       if (players.isEmpty()){
           throw new TournamentNotFoundException("tournament not found");
       }
        return players;
    }


}
