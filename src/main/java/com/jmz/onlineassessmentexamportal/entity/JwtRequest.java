package com.jmz.onlineassessmentexamportal.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest
{
    @Getter@Setter
    String username;
    @Getter@Setter 
    String password;

}
