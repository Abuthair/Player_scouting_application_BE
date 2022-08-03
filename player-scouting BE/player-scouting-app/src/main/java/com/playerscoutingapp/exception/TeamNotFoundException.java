package com.playerscoutingapp.exception;
/**
 * @author Sheika Abuthair
 * @Date : 16-05-2022
 * @Project : assignmentProject
 */
public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException() {
    }
    /**
     * this method helps us to display message
     * @param message
     */
    public TeamNotFoundException(String message) {
        super(message);
    }
}
