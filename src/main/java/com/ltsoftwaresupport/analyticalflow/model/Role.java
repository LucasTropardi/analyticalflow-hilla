package com.ltsoftwaresupport.analyticalflow.model;


import lombok.Getter;

public enum Role {
    ADMIN("Administrador"),
    USER("Usuário");

    @Getter
    private String role;

    Role(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
