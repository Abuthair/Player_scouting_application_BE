package com.playerscoutingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @Column(name = "team_id")
    @GeneratedValue(generator = "team_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "team_gen",sequenceName = "team_seq",initialValue = 100,allocationSize = 1)
    private Integer teamId;
    @Column(length = 30)
    private String teamName;
    @Column(length = 30)
    private String city;
    @Column(length = 40)
    private String trophies;
    @Column(length = 40)
    private String league;
    /**
     * In a one-to-many relationship, one record in a table can be associated with one or more records in another table
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "team")
    @JsonIgnore
    private Set<Player> players;
    /**
     * A relationship is a connection between two types of entities
     */

    @ManyToMany(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(
            name = "team_tournament",
            joinColumns ={
                    @JoinColumn(name = "team_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "tournament_id")
            }
    )
    private Set<Tournament>tournaments;
/**
 * In a one-to-many relationship, one record in a table can be associated with one or more records in another table
 */
//    @OneToMany(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "team_id")
//    private Set<Signing> signing;

    public Team(String teamName, String city, String trophies, String league, Set<Tournament> tournaments) {
        this.teamName = teamName;
        this.city = city;
        this.trophies = trophies;
        this.league = league;
        this.tournaments = tournaments;
    }


    }

