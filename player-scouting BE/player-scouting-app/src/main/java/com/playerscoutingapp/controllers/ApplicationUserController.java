package com.playerscoutingapp.controllers;

import com.playerscoutingapp.model.ApplicationUser;
import com.playerscoutingapp.service.IApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sheika Abuthair
 * @Date : 20-05-2022
 * @Project : assignmentProject
 */
@RestController
public class ApplicationUserController {

private IApplicationUserService iApplicationUserService;
    @Autowired
    public void setiApplicationUserService(IApplicationUserService iApplicationUserService) {
        this.iApplicationUserService = iApplicationUserService;
    }
    private PasswordEncoder passwordEncoder;
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/")
    public ResponseEntity<String> addUser(@RequestBody ApplicationUser user){
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        ApplicationUser appUser = new ApplicationUser(username,password);
        iApplicationUserService.addUser(appUser);
        return ResponseEntity.ok("User added");
    }
    @PutMapping("/")
    public ResponseEntity<String> updateUser(@RequestBody ApplicationUser user){
        int userId = user.getUserId();
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        ApplicationUser appUser = new ApplicationUser(userId,username,password);
        iApplicationUserService.updateUser(appUser);
        return ResponseEntity.ok("User updated");
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")int userid){
        iApplicationUserService.deleteUser(userid);
        return ResponseEntity.ok("User has been deleted");
    }

}
