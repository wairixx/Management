package com.example.Management.entity;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER");
    private final String roleName;
    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getFullRoleName(){
        return "ROLE_"+roleName;
    }
}
