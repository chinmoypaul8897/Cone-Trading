package com.cone.trading.model;

import com.cone.trading.domain.USER_ROLE;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import javax.naming.ldap.PagedResultsControl;
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String fullName ;
    private String email ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password ;

    @Embedded
    private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TwoFactorAuth getTwoFactorAuth() {
        return twoFactorAuth;
    }

    public void setTwoFactorAuth(TwoFactorAuth twoFactorAuth) {
        this.twoFactorAuth = twoFactorAuth;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

}
