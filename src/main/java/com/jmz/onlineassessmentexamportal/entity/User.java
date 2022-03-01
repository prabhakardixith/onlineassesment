package com.jmz.onlineassessmentexamportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode(exclude = "userRoles")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@ToString
public class User implements UserDetails {

    @Getter@Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter@Setter
    private String username;
    @Getter@Setter
    private String password;
    @Getter@Setter
    private String firstname;
    @Getter@Setter
    private String lastname;
    @Getter@Setter
    private String email;
    @Getter@Setter
    private String phone;
    @Getter@Setter
    private boolean enabled = true;
    @Getter@Setter
    private String profile;

    //user many roles
    @Getter@Setter
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    private Set<UserRoles> userRoles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Authority> set = new HashSet<>();
        this.userRoles.forEach(userRoles ->
        {
            set.add(new Authority(userRoles.getRole().getRoleName()));
        });

        return set;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}