package com.playerscoutingapp.service;

import com.playerscoutingapp.model.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Sheika Abuthair
 * @Date : 20-05-2022
 * @Project : assignmentProject
 */
public interface IApplicationUserService {
    /**
     * loaduserByUserName this method is used to get Username
     * @param username
     * @throws UsernameNotFoundException
     */
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * addUser this method is used to addUser
     * @param appUser
     */
    void addUser(ApplicationUser appUser);

    /**
     * updateUser this method is used to updateUser
     * @param appUser
     */
    void  updateUser(ApplicationUser  appUser);

    /**
     * deleteUser this method is used to deleteUser
     * @param userId
     */
    void  deleteUser(int userId);
}
