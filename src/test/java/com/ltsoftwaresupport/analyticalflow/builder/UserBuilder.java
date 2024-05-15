package com.ltsoftwaresupport.analyticalflow.builder;

import com.ltsoftwaresupport.analyticalflow.model.Role;
import com.ltsoftwaresupport.analyticalflow.model.User;

public class UserBuilder {

    private User user;

    public static UserBuilder build() {
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.user = new User();
        userBuilder.user.setName("Manuelson");
        userBuilder.user.setLastname("Josuelson");
        userBuilder.user.setEmail("manuelsonjosuelson@msn.com");
        userBuilder.user.setPassword("123456");
        userBuilder.user.setRole(Role.USER);
        return userBuilder;
    }

    public UserBuilder addName(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder addLastname(String lastname) {
        user.setLastname(lastname);
        return this;
    }

    public UserBuilder addEmail(String email) {
        user.setEmail(email);
        return this;
    }

    public UserBuilder addPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder addRole(Role role) {
        user.setRole(role);
        return this;
    }

    public User now() {
        return user;
    }
}
