package com.playerscoutingapp.exception;


import com.playerscoutingapp.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
/**
 * @author Sheika Abuthair
 * @Date : 20-05-2022
 * @Project : assignmentProject
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     *it will handle method exception
     * @param ex
     * @param headers
     * @param status
     * @param request
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Method not allowed");
        String error= ex.getMessage();
        List<String> messages=Arrays.asList(error,"Method not supported");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     * it will handle media type not support exception
     * @param ex
     * @param headers
     * @param status
     * @param request
     */
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Media Type Not Supported");
        String error= ex.getMessage();
        List<String> messages=Arrays.asList(error,"invalid Media Type");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     *it will handle missing path variable exception
     * @param ex
     * @param headers
     * @param status
     * @param request
     */
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       headers.add("desc"," path variable is missing");
       String error = ex.getMessage();
       List<String> messages= Arrays.asList(error,"Missing Path variable");
       ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
       return  ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     * it will handle the missing servlet request parameter exception
     * @param ex
     * @param headers
     * @param status
     * @param request
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","req param is missing");
        String error = ex.getMessage();
        List<String> messages= Arrays.asList(error,"invalid request param");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return  ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     * it will handle type mismatch exception
     * @param ex
     * @param headers
     * @param status
     * @param request
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Invalid dataType");
        String error = ex.getMessage();
        List<String> messages= Arrays.asList(error,"Invalid data type");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status, status.value(), error,messages);
        return  ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     * it will handle playerNotFound exception
     * @param ex
     */
    @ExceptionHandler(PlayerNotFoundException.class)
    public  ResponseEntity<Object> handlePlayerNotFound(Exception ex){
        HttpHeaders  headers = new HttpHeaders();
        headers.add("desc","PlayerNotFoundException");
        String error = ex.getMessage();
        List<String> messages= Arrays.asList(error,"Player not Available");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(), error,messages);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errors);
    }

    /**
     * it will handle signingNotFoundException
     * @param ex
     */
    @ExceptionHandler(SigningNotFoundException.class)
    public  ResponseEntity<Object> handleSigningNotFound(Exception ex){
        HttpHeaders  headers = new HttpHeaders();
        headers.add("desc","SigningNotFoundException");
        String error = ex.getMessage();
        List<String> messages= Arrays.asList(error,"Signing not Available");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(), error,messages);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errors);
    }

    /**
     * it will handle teamNotFoundException
     * @param ex
     */
    @ExceptionHandler(TeamNotFoundException.class)
    public  ResponseEntity<Object> handleTeamNotFound(Exception ex){
        HttpHeaders  headers = new HttpHeaders();
        headers.add("desc","TeamNotFoundException");
        String error = ex.getMessage();
        List<String> messages= Arrays.asList(error,"Team not Available");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(), error,messages);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errors);
    }

    /**
     * it will handle tournamentNotFoundException
     * @param ex
     */
    @ExceptionHandler(TournamentNotFoundException.class)
    public  ResponseEntity<Object> handleTournamentNotFound(Exception ex){
        HttpHeaders  headers = new HttpHeaders();
        headers.add("desc","TeamNotFoundException");
        String error = ex.getMessage();
        List<String> messages= Arrays.asList(error,"Team not Available");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(), error,messages);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errors);
    }

    /**
     * it will handle other Exception
     * @param ex
     */
    @ExceptionHandler(Exception.class)
    public  ResponseEntity<Object> handleOther(Exception ex){
        HttpHeaders  headers = new HttpHeaders();
        headers.add("desc","Other Exception");
        String error = ex.getMessage();
        List<String> messages= Arrays.asList(error,"Other type of exception");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.NOT_ACCEPTABLE,HttpStatus.NOT_ACCEPTABLE.value(),error,messages);
        return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(errors);
    }
}
