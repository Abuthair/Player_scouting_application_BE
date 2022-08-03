package com.playerscoutingapp.model;

/**
 * @author Sheika Abuthair
 *@Date : 16-05-2022
 *@Project : assignmentProject
 */
public enum League {
    FIRSTCLASS("First Class Cricket"),
    SECONDCLASS("Second Class Cricket"),
    THIRDCLASS("Third Class Cricket");

    private String type;

    League(String type) {
        this.type = type;
    }
}
