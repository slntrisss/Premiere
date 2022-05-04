package org.billboard.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static org.billboard.security.ApplicationUserPermission.*;
public enum ApplicationUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(
            CINEMA_READ,
            CINEMA_WRITE,
            MOVIE_READ,
            MOVIE_WRITE,
            SCHEDULE_READ,
            SCHEDULE_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
