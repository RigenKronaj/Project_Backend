package com.example.project.Service;

import java.util.Collection;

import com.example.project.Model.User;

public interface UserService {
    public abstract Collection<User> getUser(Integer UID);
}
