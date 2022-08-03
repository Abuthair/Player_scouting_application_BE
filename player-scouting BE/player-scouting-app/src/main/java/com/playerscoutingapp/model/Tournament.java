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
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tournament {
    @Id
    @Column(name = "tournament_id")
    @GeneratedValue(generator = "tournament_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "tournament_gen",sequenceName = "tournament_seq",allocationSize = 1,initialValue = 1)
    private Integer tournamentId;
    @Column(length = 50)
    private String tournamentName;
    @Column(length = 30)
    private String state;
    @Column(length = 50)
    private String tournamentFormat;
    /**
     * A relationship is a connection between two types of entities
     */
    @ManyToMany(mappedBy = "tournaments",fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JsonIgnore
    private Set<Team> teams;


}
