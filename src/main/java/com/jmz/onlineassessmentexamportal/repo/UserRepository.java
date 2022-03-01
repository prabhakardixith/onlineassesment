package com.jmz.onlineassessmentexamportal.repo;

import com.jmz.onlineassessmentexamportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}
