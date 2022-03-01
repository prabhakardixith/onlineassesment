package com.jmz.onlineassessmentexamportal.services;

import com.jmz.onlineassessmentexamportal.entity.User;
import com.jmz.onlineassessmentexamportal.entity.UserRoles;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface UserService
{
    //create User
    public User createUser(User user, Set<UserRoles> userRoles) throws Exception;

    //get user by username
    public User findByUsername(String username);

    //delete user by id
    public void deleteUser(long userId);
}
