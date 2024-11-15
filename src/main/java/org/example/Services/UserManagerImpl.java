package org.example.Services;

import org.example.Enums.Role;
import org.example.Model.User;

import java.util.HashMap;
import java.util.Map;

public class UserManagerImpl implements UserManager {
    private Map<String, User> usersList;

    public UserManagerImpl() {
        this.usersList = new HashMap<>();
    }


    @Override
    public void registerUser(User user) {
        if(usersList.containsValue(user))
            System.out.println("User already exists");
        usersList.putIfAbsent(user.getEmail(), user);
        System.out.println("New user registered");
    }

    @Override
    public void login(String email, String password) {
        User user = usersList.get(email);
        if(user != null && password.equals(user.getPassword())) {
            System.out.println("Logged in");
            return;
        }
        System.out.println("Invalid email or password");
    }

    @Override
    public Role getUserRole(User user){
        if(usersList.containsValue(user)){
            System.out.println("User Role" + user.getRole());
            return user.getRole();
        }
        System.out.println("Invalid user role");
        return null;
    }
}
