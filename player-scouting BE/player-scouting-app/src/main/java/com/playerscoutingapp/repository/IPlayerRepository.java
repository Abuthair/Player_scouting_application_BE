package com.playerscoutingapp.repository;

import com.playerscoutingapp.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */

@Repository
public interface IPlayerRepository extends JpaRepository<Player,Integer> {
    /**
     * this query helps us to find list of players by name
     * @param playerName
     *
     */

    List<Player> findByPlayerNameStartingWith(String playerName);

    /**
     * this query helps us to find list of players by age
     * @param age
     */
    List<Player> findByAge(int age) ;

    /**
     * this query helps us to find list of players by country
     * @param country
     */
    List<Player> findByCountry(String country) ;

    /**
     * this query helps us find list of players by batting
     * @param batting
     */
    List<Player> findByBatting(String batting) ;

    /**
     * this query helps us find list of players by bowling
     * @param bowling
     */
    List<Player> findByBowling(String bowling) ;

    /**
     * this query helps us find list of players by specialist
     * @param specialist
     */
    List<Player> findBySpecialist(String specialist) ;

    /**
     * this query helps us find list of players by stateTeam
     * @param StateTeam
     */
    List<Player> findByStateTeam(String StateTeam) ;

    /**
     * this query helps us find list of players by teamName
     * @param teamName
     */
    @Query("from Player p inner join p.team t where t.teamName=?1")
    List<Player> findByTeamName(String teamName) ;

    /**
     * this query helps us find list of players by city
     * @param city
     */
    @Query("from Player p inner join p.team t where t.city=?1")
    List<Player> findByTeamCity(String city) ;

    /**
     * this query helps us find list of players by trophies
     * @param trophies
     */
    @Query("from Player p inner join p.team t where t.trophies=?1")
    List<Player> findByTeamTrophies(String trophies) ;




    /**
     * this query helps us find list of players by name and country
     * @param name
     * @param country
     */
   @Query("from Player p where p.playerName like ?1 and p.country=?2")
    List<Player> findByNameCountryStartingWith(String name, String country) ;

    /**
     * this query helps us find list of players by batting and bowling
     * @param batting
     * @param bowling
     */
    @Query("from Player p where p.batting=?1 and p.bowling=?2")
    List<Player> findByBattingBowling(String batting, String bowling) ;

    /**
     * this query helps us find list of players basePrice between basePrice1 and basePrice2
     * @param basePrice1
     * @param basePrice2
     */
   @Query("from Player p where p.basePrice between ?1 and ?2")
    List<Player> findByPriceBetween(double basePrice1, double basePrice2) ;

    /**
     * this query helps us find list of players basePrice between basePrice1 and basePrice2 with batting
     * @param basePrice1
     * @param basePrice2
     */
    @Query("from Player p where p.basePrice between ?1 and ?2 and p.batting=?3")
    List<Player> findByPriceBetweenBatting(double basePrice1,double basePrice2,String batting);
    /**
     * this query helps us find list of players basePrice between basePrice1 and basePrice2 with bowling
     * @param basePrice2
     */
   @Query("from Player p where p.basePrice between ?1 and ?2 and p.bowling=?3")
    List<Player> findByPriceBetweenBowling(double basePrice1,double basePrice2,String bowling);

    /**
     * this query helps us find list of players using tournamentName
     * @param tournamentName
     */
   @Query("from Player p inner join p.team t inner join t.tournaments to where to.tournamentName=?1 ")

    List<Player> findByTournamentName(String tournamentName);

    /**
     * this query helps us find list of players using tournamentFormat
     * @param tournamentFormat
     */
    @Query("from Player p inner join p.team t inner join t.tournaments to where to.tournamentFormat=?1 ")
    List<Player> findTournamentFormat(String tournamentFormat);

}
