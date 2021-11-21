package org.example.storage;

import org.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserStorage {

    private final ArrayList<User> userArrayList;

    public UserStorage(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public void saveUser(User user){
        userArrayList.add(user);
    }

    public boolean checkUser(String username){
        for(User list : userArrayList){
            if(username.equals(list.getUsername())){
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String username, String password){
        for (User list : userArrayList){
            if (username.equals(list.getUsername())){
                if (password.equals(list.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }

    public User singInUser(String username, String password){
        for (User list : userArrayList) {
            if (username.equals(list.getUsername())) {
                if (password.equals(list.getPassword())) {
                    return list;
                }
            }
        }
        return null;
    }

}
