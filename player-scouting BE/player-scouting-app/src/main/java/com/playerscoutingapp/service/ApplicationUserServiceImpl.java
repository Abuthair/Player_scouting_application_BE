package com.playerscoutingapp.service;

import com.playerscoutingapp.model.ApplicationUser;
import com.playerscoutingapp.repository.IApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Sheika Abuthair
 * @Date : 20-05-2022
 * @Project : assignmentProject
 */

@Service
public class ApplicationUserServiceImpl implements  IApplicationUserService, UserDetailsService {
//IApplicationUser Repository is Autowired using setter method
   private IApplicationUserRepository iApplicationUserRepository;
     @Autowired
    public void setiApplicationUserRepository(IApplicationUserRepository iApplicationUserRepository) {
        this.iApplicationUserRepository = iApplicationUserRepository;
    }

    /**
     *loadUserByUsername this method implementation allows us to set roles for user and admin
     * @param username
     * @throws UsernameNotFoundException
     */
    @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser appUser=iApplicationUserRepository.findByUsername(username);
        String susername=appUser.getUsername();
        String password=appUser.getPassword();
//Set roles for the user
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        GrantedAuthority authority1=new SimpleGrantedAuthority("ADMIN");
//create a new user object using UserDetails interface
        UserDetails user=new User(susername,password, Arrays.asList(authority,authority1));


        return user;
    }

    /**
     * addUser this method implementation allows us to add user
     * @param appUser
     */
    @Override
    public void addUser(ApplicationUser appUser) {
        iApplicationUserRepository.save(appUser);
    }
    /**
     * addUser this method implementation allows us to update user
     * @param appUser
     */
    @Override
    public void updateUser(ApplicationUser appUser) {
        iApplicationUserRepository.save(appUser);
    }
    /**
     * addUser this method implementation allows us to delete user  using userId
     * @param userId
     */
    @Override
    public void deleteUser(int userId) {
     iApplicationUserRepository.deleteById(userId);
    }
}
