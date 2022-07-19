package com.et.user.domain.service;

import com.et.user.domain.entity.User;

public interface UserDomainService {

    void createUser(User user);
    void updateUser(User user, String email, String username);
    void deleteUser(User user);

    void updateUserPassword(User user, String newPassword);
}
