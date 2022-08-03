package com.playerscoutingapp.exception;

/**
 * @author Sheika Abuthair
 * @Date : 17-05-2022
 * @Project : assignmentProject
 */
public class TournamentNotFoundException extends RuntimeException{
    public TournamentNotFoundException() {
    }
    /**
     * this method helps us to display message
     * @param message
     */
    public TournamentNotFoundException(String message) {
        super(message);
    }
}
