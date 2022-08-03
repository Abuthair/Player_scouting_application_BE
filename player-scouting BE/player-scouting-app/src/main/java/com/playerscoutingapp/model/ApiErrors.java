package com.playerscoutingapp.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
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
public class ApiErrors {
    LocalDateTime timestamp;
    HttpStatus status;
    int statusCode;
    String error;
    List<String> message;

}
