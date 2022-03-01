package com.jmz.onlineassessmentexamportal.controller;

import com.jmz.onlineassessmentexamportal.entity.Role;
import com.jmz.onlineassessmentexamportal.entity.User;
import com.jmz.onlineassessmentexamportal.entity.UserRoles;
import com.jmz.onlineassessmentexamportal.helper.ExceptionClass;
import com.jmz.onlineassessmentexamportal.helper.UserFoundException;
import com.jmz.onlineassessmentexamportal.helper.UserNotFoundException;
import com.jmz.onlineassessmentexamportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //create user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("default.jpg");

        //encoding password with bcryptpasswordencoder

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRoles> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRoles userRoles = new UserRoles();
        userRoles.setUser(user);
        userRoles.setRole(role);

        roles.add(userRoles);

       return this.userService.createUser(user,roles);
    }

    //get user by id
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username)
    {
        User byUsername = this.userService.findByUsername(username);
        if (byUsername != null) {return byUsername;}
        else {return new User();}
    }

    //delete user by id
    @DeleteMapping("/{userId}")
    public void deleteUser (@PathVariable("userId") Long userId)
    {
        this.userService.deleteUser(userId);
    }

    //update user api

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException e)
    {
        ExceptionClass exceptionClass = new ExceptionClass();
        exceptionClass.setStatus(HttpStatus.BAD_REQUEST);
        exceptionClass.setMessage(e.getMessage());
        exceptionClass.setError(e.getLocalizedMessage());
        exceptionClass.setTime(new Date().toString());
        return new ResponseEntity( exceptionClass,HttpStatus.EXPECTATION_FAILED);
    }
}
