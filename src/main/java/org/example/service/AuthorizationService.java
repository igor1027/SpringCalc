package org.example.service;

import org.example.entity.User;
import org.example.storage.UserStorage;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationService {

    private final UserStorage usStorage;

    public AuthorizationService(UserStorage usStorage) {
        this.usStorage = usStorage;
    }

    public boolean checkUsername(String username){
        return usStorage.checkUser(username);
    }

    public boolean checkPassword(String username, String password){
        return usStorage.checkPassword(username, password);
    }

    public User singInUser(String username, String password){
        return usStorage.singInUser(username, password);
    }
}
