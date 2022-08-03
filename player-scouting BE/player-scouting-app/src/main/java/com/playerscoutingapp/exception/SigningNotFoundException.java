package com.playerscoutingapp.exception;

/**
 * @author Sheika Abuthair
 * @Date : 17-05-2022
 * @Project : assignmentProject
 */
public class SigningNotFoundException extends RuntimeException{
    public SigningNotFoundException() {
    }
    /**
     * this method helps us to display message
     * @param message
     */
    public SigningNotFoundException(String message) {
        super(message);
    }
}
