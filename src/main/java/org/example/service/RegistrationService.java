package org.example.service;

import org.example.entity.User;
import org.example.storage.UserStorage;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {
    private final UserStorage userStorage;

    public RegistrationService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void saveUser(User user){
        userStorage.saveUser(user);
    }
}
