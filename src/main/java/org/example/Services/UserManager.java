package org.example.Services;

import org.example.Enums.Role;
import org.example.Model.User;

public interface UserManager {
    public void registerUser(User user);
    public void login(String email, String password);
    public Role getUserRole(User user);
}
