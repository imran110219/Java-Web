package com.sadman.springbootlogin2.service;

import com.sadman.springbootlogin2.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
