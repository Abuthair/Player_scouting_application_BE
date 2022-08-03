package com.playerscoutingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Player {
    @Id
    //@Column(name = "playerid")
    @GeneratedValue(generator = "player_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "player_gen",sequenceName = "player_seq",initialValue = 1,allocationSize = 1)
    private Integer playerId;
    @Column(length = 30)
    private String playerName;
    @Column(nullable = false)
    private int age;
    @Column(length = 20)
    private  String country;
    @Column(length = 30)
    private String batting;
    @Column(length = 30)
    private String bowling;
    @Column(length = 40)
    private String specialist;
    @Column(length = 30)
    private String stateTeam;
    @Column(nullable = false)
    private double basePrice;

    /**
     * The Many-To-One mapping represents a single-valued association where a collection of entities can be associated with the similar entity
     */
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")

    private Team team;

    @OneToOne(mappedBy = "player")
    @JsonIgnore
   private Signing signing;


    }


