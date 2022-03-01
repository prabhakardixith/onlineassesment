package com.jmz.onlineassessmentexamportal.services.impl;

import com.jmz.onlineassessmentexamportal.entity.User;
import com.jmz.onlineassessmentexamportal.entity.UserRoles;
import com.jmz.onlineassessmentexamportal.repo.RoleRepository;
import com.jmz.onlineassessmentexamportal.repo.UserRepository;
import com.jmz.onlineassessmentexamportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRoles> userRoles) throws Exception {

         User local  = this.userRepository.findByUsername(user.getUsername());
         if(local != null)
         {
             System.out.println("User Already exists");
             throw new Exception("User already present");
         }
         else
         {
             //user create
             for(UserRoles ur:userRoles)
             {
                 this.roleRepository.save(ur.getRole());
             }
          //   user.setRoles(userRoles);
             user.getUserRoles().addAll(userRoles);
             local = this.userRepository.save(user);

         }
        return local;
    }

    @Override
    public User findByUsername(String username) {

      return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }
}
