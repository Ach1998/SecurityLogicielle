package com.example.demo.Security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {
    USER(Sets.newHashSet(ApplicationUserPermission.USER_WRITE)),
    ADMIN(Sets.newHashSet(ApplicationUserPermission.USER_READ,ApplicationUserPermission.USER_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
    this.permissions=permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAutorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission->new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority(("ROLE_"+this.name())));
        return  permissions;
    }
}

