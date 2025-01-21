package com.betaplan.anjeza.store.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserPropertyResolver {

    @Value("${example.user.name}")
    private String userName;

    @Value("${example.user.surname}")
    private String userSurname;

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }
}
