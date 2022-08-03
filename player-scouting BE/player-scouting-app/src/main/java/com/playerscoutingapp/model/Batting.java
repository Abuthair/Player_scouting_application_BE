package com.playerscoutingapp.model;

/**
 *@author Sheika Abuthair
 *@Date : 16-05-2022
 *@Project : assignmentProject
 */
public enum Batting {
 RIGHTHANDBATSMAN("Right Hand Batsman"),
 LEFTHANDBATSMAN("Left Hand Batsman"),
 ;

 private String type;

 Batting(String type) {
  this.type = type;
 }
}
