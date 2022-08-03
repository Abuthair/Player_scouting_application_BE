package com.playerscoutingapp.controllers;
import com.playerscoutingapp.model.Player;
import com.playerscoutingapp.model.Signing;
import com.playerscoutingapp.model.Team;
import com.playerscoutingapp.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */
@RestController
@RequestMapping("/player-api")

public class PlayerController {
//IPlayerService is Autowired with setter method
    private  IPlayerService iPlayerService;
    @Autowired
    public void setPlayerService(IPlayerService iPlayerService) {
        this.iPlayerService = iPlayerService;
    }


    /**
     * @PostMapping this   api call  helps us to add players
     * @param player
     */
    @PostMapping("/admin/players")
    ResponseEntity<Void> addPlayer(@RequestBody Player player){
        iPlayerService.addPlayer(player);
    ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }

    /**
     * @PutMapping  this  api call  helps us to update player
     * @param player
     */
    @PutMapping("/admin/players")
    ResponseEntity<Void> updatePlayer(@RequestBody Player player){
        iPlayerService.updatePlayer(player);
    ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return responseEntity;
    }

    /**
     * @DeleteMapping this  api call  helps us to delete player
     * @param playerId
     */
    @DeleteMapping("/admin/players/playerId/{playerId}")
    ResponseEntity<Void> deletePlayer(@PathVariable ("playerId") int playerId){
        iPlayerService.deletePlayer(playerId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","delete one player by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }

    /**
     * @GetMapping this  api call  helps us to get the player using playerId
     * @param playerId
     */
    //http://localhost:8080/player-api/user/players/playerId/1
    @GetMapping("/user/players/playerId/{playerId}")
    ResponseEntity<Player> getByPlayerId (@PathVariable("playerId") int playerId){
        Player player = iPlayerService.getByPlayerId(playerId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","get one player by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(player);
    }

    /**
     * @GetMapping this  api call  helps us to get the All the players
     * @return  All players
     */
    //http://localhost:8080/player-api/admin/players
    @GetMapping("/admin/players")
    ResponseEntity<List<Player>> getAll(){
        List<Player> players =iPlayerService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all players");
        ResponseEntity<List<Player>>responseEntity= new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @GetMapping this  api call  helps us to get the player using playerName
     * @param playerName
     */
    //http://localhost:8080/player-api/user/players/playerName/A
    @GetMapping("/user/players/playerName/{playerName}")
    ResponseEntity<List<Player>> getByNameStartingWith(@PathVariable("playerName") String playerName){
    List<Player> players = iPlayerService.getByPlayerNameStartingWith(playerName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by playerName");
        ResponseEntity<List<Player>>responseEntity= new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @GetMapping this   api call   helps us to get the player using age
     * @param age

     */
    //http://localhost:8080/player-api/user/players/age/31
    @GetMapping("/user/players/age/{age}")
   ResponseEntity <List<Player>> getByAge(@PathVariable("age") int age) {
    List<Player> players = iPlayerService.getByAge(age);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by player's age");
        ResponseEntity<List<Player>>responseEntity= new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @GetMapping this  api call  helps us to get the player using country
     * @param country
     */
    //http://localhost:8080/player-api/user/players/country/India
    @GetMapping("/user/players/country/{country}")
    ResponseEntity<List<Player>> getByCountry(@PathVariable("country") String country){
        List<Player> players =iPlayerService.getByCountry(country);
    HttpHeaders headers = new HttpHeaders();
    headers.add("desc","getting by players's country");
    ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @GetMapping this  api call  helps us to get the player using batting
     * @param batting
     * @return
     */
    //http://localhost:8080/player-api/user/players/batting/Left Hand Batsman
    @GetMapping("/user/players/batting/{batting}")
    ResponseEntity<List<Player>> getByBatting(@PathVariable("batting") String batting) {
     List<Player> players =iPlayerService.getByBatting(batting);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by Batsman");
        ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @GetMapping this api call helps us to get the player using bowling
     * @param bowling
     */
    //http://localhost:8080/player-api/user/players/bowling/Left Hand Spin Bowler
    @GetMapping("/user/players/bowling/{bowling}")
    ResponseEntity<List<Player>> getByBowling(@PathVariable("bowling") String bowling){
      List<Player> players =iPlayerService.getByBowling(bowling);
      HttpHeaders headers = new HttpHeaders();
      headers.add("desc","getting by Bowler");
      ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
      return responseEntity;
    }

    /**
     * @GetMapping this  api call  helps us to get the player using specialist
     * @param specialist
     */
    //http://localhost:8080/player-api/user/players/specialist/Death Over Specialist
    @GetMapping("/user/players/specialist/{specialist}")
    ResponseEntity<List<Player>> getBySpecialist(@PathVariable("specialist") String specialist) {
        List<Player> players =iPlayerService.getBySpecialist(specialist);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by player's specialist");
        ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @GetMapping this   api call  helps us to get the player using stateTeam
     * @param StateTeam
     */
    //http://localhost:8080/player-api/user/players/stateTeam/TamilNadu
    @GetMapping("/user/players/stateTeam/{stateTeam}")
    ResponseEntity<List<Player>> getByStateTeam(@PathVariable("stateTeam") String StateTeam){
       List<Player> players = iPlayerService.getByStateTeam(StateTeam);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by player's stateTeam");
        ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;

    }

    /**
     * @GetMapping this api call helps us to get the team using teamName
     * @param teamName
     */
    //http://localhost:8080/player-api/user/players/teamName/Chennai Super Kings
    @GetMapping("/user/players/teamName/{teamName}")
    ResponseEntity<List<Player>> getByTeamName(@PathVariable("teamName") String teamName){
     List<Player> players = iPlayerService.getByTeamName(teamName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by teamName");
        ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @GetMapping this  api call  helps us to get the team using city
     * @param city
     */
    //http://localhost:8080/player-api/user/players/teamCity/UP
    @GetMapping("/user/players/teamCity/{teamCity}")
    ResponseEntity<List<Player>> getByTeamCity(@PathVariable("teamCity") String city){
        List<Player> players = iPlayerService.getByTeamCity(city);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by teamCity");
        ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
     }

    /**
     * @GetMapping this  api call  helps us to get the team using trophies
     * @param trophies
     */
    //http://localhost:8080/player-api/user/players/teamTrophies/IPL 2010,IPL 2018
     @GetMapping("/user/players/teamTrophies/{teamTrophies}")
    ResponseEntity<List<Player>> getByTeamTrophies(@PathVariable("teamTrophies") String trophies){
        List<Player> players =iPlayerService.getByTeamTrophies(trophies);
         HttpHeaders headers = new HttpHeaders();
         headers.add("desc","getting by trophies");
         ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
         return responseEntity;
    }



    /**
     * @GetMapping this  api call  helps us to get the player using playerName and country
     * @param name
     * @param country
     */
    //http://localhost:8080/player-api/user/players/playerName/A/country/India
    @GetMapping("/user/players/playerName/{playerName}/country/{country}")
    ResponseEntity<List<Player>> getByNameCountryStartingWith(@PathVariable("playerName") String name,@PathVariable("country") String country){
        List<Player> players =iPlayerService.getByNameCountryStartingWith(name, country);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by player's name and country");
        ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @GetMapping this api call helps us to get the player using batting and bowling
     * @param batting
     * @param bowling
     */
   // http://localhost:8080/player-api/user/players/batting/Right Hand Batsman/bowling/Right Hand Spin Bowler
    @GetMapping("/user/players/batting/{batting}/bowling/{bowling}")
    ResponseEntity<List<Player>> getByBattingBowling(@PathVariable("batting") String batting,@PathVariable("bowling") String bowling){
        List<Player> players = iPlayerService.getByBattingBowling(batting, bowling);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by player's batting and bowling");
        ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @GetMapping this  api call helps us to get the player using basePrice between b1 and b2
     * @param basePrice1
     * @param basePrice2
     */
    //http://localhost:8080/player-api/user/players/basePrice1/1000/basePrice2/5000
    @GetMapping("/user/players/basePrice1/{basePrice1}/basePrice2/{basePrice2}")
    ResponseEntity<List<Player>> getByPriceBetween(@PathVariable("basePrice1") double basePrice1,@PathVariable("basePrice2") double basePrice2) {
     List<Player> players = iPlayerService.getByPriceBetween(basePrice1, basePrice2);
     HttpHeaders headers = new HttpHeaders();
     headers.add("desc","getting by player's maxPrice and minPrice");
     ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
     return responseEntity;
    }

    /**
     * @GetMapping this  api call   helps us to get the player using basePrice between b1 and b2 with batting
     * @param basePrice1
     * @param basePrice2
     * @param batting
     */
    //http://localhost:8080/player-api/user/players/basePrice1/1000/basePrice2/5000/batting/Right Hand Batsman
    @GetMapping("/user/players/basePrice1/{basePrice1}/basePrice2/{basePrice2}/batting/{batting}")
    ResponseEntity<List<Player>> getByPriceBetweenBatting(@PathVariable("basePrice1") double basePrice1,@PathVariable("basePrice2") double basePrice2,@PathVariable("batting") String batting) {
        List<Player> players = iPlayerService.getByPriceBetweenBatting(basePrice1, basePrice2, batting);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by player's maxPrice and minPrice with batting");
        ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

    /**
     *@GetMapping this  api call   helps us to get the player using basePrice between b1 and b2 with bowling
     * @param basePrice1
     * @param basePrice2
     * @param bowling
     */
    //http://localhost:8080/player-api/user/players/basePrice1/1000/basePrice2/15000/bowling/Left Hand Spin Bowler
    @GetMapping("/user/players/basePrice1/{basePrice1}/basePrice2/{basePrice2}/bowling/{bowling}")
    ResponseEntity<List<Player>> getByPriceBetweenBowling(@PathVariable("basePrice1") double basePrice1,@PathVariable("basePrice2") double basePrice2,@PathVariable("bowling") String bowling){
    List<Player> players = iPlayerService.getByPriceBetweenBowling(basePrice1,basePrice2,bowling);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by player's maxPrice and minPrice with batting with bowling");
        ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @GetMapping this  api call   helps us to get the player using tournamentName
     * @param tournamentName
     */
    //http://localhost:8080/player-api/user/players/tournamentName/Indian Premier League
    @GetMapping("/user/players/tournamentName/{tournamentName}")
    ResponseEntity<List<Player>> getByTournamentName(@PathVariable("tournamentName") String tournamentName){
        List<Player> players = iPlayerService.getByTournamentName(tournamentName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by player's by tournamentName");
        ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }
    //http://localhost:8080/player-api/user/players/tournamentFormat/50 overs
    @GetMapping("/user/players/tournamentFormat/{tournamentFormat}")
    ResponseEntity<List<Player>> getTournamentFormat(@PathVariable("tournamentFormat") String tournamentFormat){
      List<Player> players =iPlayerService.getTournamentFormat(tournamentFormat);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by player's by tournamentFormat");
        ResponseEntity<List<Player>> responseEntity = new ResponseEntity<>(players,headers,HttpStatus.OK);
        return responseEntity;
    }

//    @GetMapping("/greet")
//    public String msg(){
//        return "Working now";
//    }
}



