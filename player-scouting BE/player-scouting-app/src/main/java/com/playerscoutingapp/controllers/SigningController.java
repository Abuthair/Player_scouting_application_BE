package com.playerscoutingapp.controllers;

import com.playerscoutingapp.exception.SigningNotFoundException;
import com.playerscoutingapp.model.Player;
import com.playerscoutingapp.model.Signing;
import com.playerscoutingapp.repository.IPlayerRepository;
import com.playerscoutingapp.service.IPlayerService;
import com.playerscoutingapp.service.ISigningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheika Abuthair
 * @Date : 17-05-2022
 * @Project : assignmentProject
 */
@RestController
@RequestMapping("/signing-api")
public class SigningController {
    //IPlayerService is Autowired with setter method
    IPlayerService iPlayerService;

    @Autowired
    public void setiPlayerService(IPlayerService iPlayerService) {
        this.iPlayerService = iPlayerService;
    }

    //ISigningService is Autowired with setter method
    ISigningService iSigningService;

    @Autowired
    public void setiSigningService(ISigningService iSigningService) {
        this.iSigningService = iSigningService;
    }

    /**
     * @param signing
     * @param playerId
     * @PostMapping this api call  helps us to add signing
     */
    @PostMapping("/admin/signings/playerId/{playerId}")
    ResponseEntity<Void> addSigning(@RequestBody Signing signing, @PathVariable("playerId") int playerId) {
        iSigningService.addSigning(signing, playerId);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }

    //    @PostMapping("/signings")
//    ResponseEntity<Void> addSigning(@RequestBody Signing signing) {
//
//        iSigningService.addSigning(signing);
//        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
//        return responseEntity;
//    }

    /**
     * @param signing
     * @PutMapping this api call helps us to update signing
     */
    @PutMapping("/admin/signings")
    ResponseEntity<Void> updateSigning(@RequestBody Signing signing) {
        iSigningService.updateSigning(signing);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return responseEntity;
    }

    /**
     * @param signingId
     * @DeleteMapping this api call helps us to delete signing with signingId
     */
    @DeleteMapping("/admin/signings/signingId/{signingId}")
    ResponseEntity<Void> deleteSigning(@PathVariable("signingId") int signingId) {
        iSigningService.deleteSigning(signingId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "delete one signing by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    /**
     * @GetMapping this api call helps us to get all signing
     */
    //http://localhost:8080/signing-api/admin/signings
    @GetMapping("/admin/signings")
    ResponseEntity<List<Signing>> getAll() {
        List<Signing> signings = iSigningService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting all signing");
        ResponseEntity<List<Signing>> responseEntity = new ResponseEntity<>(signings, headers, HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @param signingId
     * @GetMapping this api call helps us get the signing using signingId
     */
    //http://localhost:8080/signing-api/user/signings/signingId/1
    @GetMapping("/user/signings/signingId/{signingId}")
    ResponseEntity<Signing> getById(@PathVariable("signingId") int signingId) {
        Signing signing = iSigningService.getById(signingId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by signingId");
        ResponseEntity<Signing> responseEntity = new ResponseEntity<>(signing, headers, HttpStatus.OK);
        return responseEntity;
    }

    /**
     * @param price
     * @GetMapping this api call helps us get the signing using price
     */
    //http://localhost:8080/signing-api/signings/price/18000
    @GetMapping("/signings/price/{price}")
    ResponseEntity<List<Signing>> getByPrice(@PathVariable("price") double price) {
        List<Signing> signings = iSigningService.getByPrice(price);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by price");
        ResponseEntity<List<Signing>> responseEntity = new ResponseEntity<>(signings, headers, HttpStatus.OK);
        return responseEntity;
    }



}
