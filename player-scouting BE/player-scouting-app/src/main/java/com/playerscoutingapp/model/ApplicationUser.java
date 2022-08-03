package com.playerscoutingapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Sheika Abuthair
 * @Date : 20-05-2022
 * @Project : assignmentProject
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ApplicationUser {
    @Column(unique = true,length = 30)
    private String username;
    private String password;
    @Id
    @GeneratedValue
    private  Integer userId;

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ApplicationUser(int userId, String username, String password) {
    }
}

