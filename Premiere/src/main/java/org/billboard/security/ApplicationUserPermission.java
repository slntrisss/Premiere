package org.billboard.security;

public enum ApplicationUserPermission {
    CINEMA_READ("cinema:read"),
    CINEMA_WRITE("cinema:write"),
    MOVIE_READ("movie:read"),
    MOVIE_WRITE("movie:write"),
    SCHEDULE_READ("schedule:read"),
    SCHEDULE_WRITE("schedule:write");

    private final String permission;


    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
