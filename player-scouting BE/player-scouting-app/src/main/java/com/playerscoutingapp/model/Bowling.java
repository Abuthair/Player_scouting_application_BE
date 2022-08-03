package com.playerscoutingapp.model;
/**
 * @author Sheika Abuthair
 *@Date : 16-05-2022
 *@Project : assignmentProject
 */

public enum Bowling {

    RIGHTHANDFASTBOWLER("Right Hand Fast Bowler"),
    LEFTHANDFASTBOWLER("Left Hand Fast Bowler"),
    RIGHTHANDSPINNER("Right Hand Spin Bowler"),
    LEFTHANDSPINNER("Left Hand Spin Bowler");


    private String type;

    Bowling(String type) {
        this.type = type;
    }
}
