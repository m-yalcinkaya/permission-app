package com.mustafa.permissionApp2.dto;

import com.mustafa.permissionApp2.jpa.entities.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest (
        String name,
        String surname,
        String username,
        String password,
        Set<Role> authorities
) {
}
