package com.playerscoutingapp.exception;
/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */


public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException() {
    }

    /**
     * this method helps us to display message
     * @param message
     */
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
