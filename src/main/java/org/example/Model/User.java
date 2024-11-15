package org.example.Model;

import org.example.Enums.Role;

import java.util.Date;
import java.util.UUID;

public class User {
    public String id;
    public String name;
    public String password;
    public String email;
    public String birthday;
    public org.example.Enums.Role role;

    public User(String name, String email, String birthday, String id, Role role, String password) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.id = id;
        this.role = role;
        this.password = password;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getEmail() {
        return email;
    }

    public org.example.Enums.Role getRole() {
        return role;
    }
    public String getPassword() {
        return password;
    }
}
