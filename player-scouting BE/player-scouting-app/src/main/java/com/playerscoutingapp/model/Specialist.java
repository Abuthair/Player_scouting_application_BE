package com.playerscoutingapp.model;

/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */
public enum Specialist {

    OPENINGBATSMAN("Opening Batsman"),
    TOPORDERBATSMAN("Top Order Batsman"),
    MIDDLEORDERBATSMAN("Middle Order Batsman"),
    NEWBALLBOWLER("New Ball Bowler"),
    POWERPLAYSPINNER("Powerplay Spinner"),
    WICKERKEEPER("Wicket keeper"),
    DEATHOVERSPECIALIST("Death Over Specialist");


    private String type;

    Specialist(String type) {
        this.type = type;
    }
}
