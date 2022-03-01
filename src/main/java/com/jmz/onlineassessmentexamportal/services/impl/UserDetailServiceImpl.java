package com.jmz.onlineassessmentexamportal.services.impl;

import com.jmz.onlineassessmentexamportal.entity.User;
import com.jmz.onlineassessmentexamportal.helper.UserFoundException;
import com.jmz.onlineassessmentexamportal.repo.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username)   {

        User byUsername = this.userRepository.findByUsername(username);
        if(byUsername ==null)
        {
            System.out.println("user already exists");
            throw new UserFoundException();
        }
        else{
            return byUsername;
        }
    }
}
