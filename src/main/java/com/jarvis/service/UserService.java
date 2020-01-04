package com.jarvis.service;

import com.jarvis.entity.AppUser;

public interface UserService {
    void save(AppUser user);

    AppUser findByUsername(String username);
}
