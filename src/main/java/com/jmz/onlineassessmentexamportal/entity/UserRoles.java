package com.jmz.onlineassessmentexamportal.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class UserRoles
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    //user
    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "userId",referencedColumnName = "id")
    private User user;

    //role
    @ManyToOne
//    @JoinColumn(name = "roleId",referencedColumnName = "roleId")
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserRoles userRoles = (UserRoles) o;
        return userRoleId != null && Objects.equals(userRoleId, userRoles.userRoleId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
