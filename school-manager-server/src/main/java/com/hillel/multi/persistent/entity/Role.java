package com.hillel.multi.persistent.entity;

import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

    public static final String USER_ADMIN = "USER_ADMIN";

    @Override
    public String getAuthority() {
        return null;
    }
}