package com.et.user.domain.service;

import com.et.user.domain.entity.User;

public interface UserDomainService {

    void createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
