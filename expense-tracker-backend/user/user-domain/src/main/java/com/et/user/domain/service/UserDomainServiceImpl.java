package com.et.user.domain.service;

import com.et.user.domain.entity.User;

public class UserDomainServiceImpl implements UserDomainService{
    @Override
    public void createUser(User user) {
        user.createUser();
    }

    @Override
    public void updateUser(User user, String email, String username) {
        user.updateUser(username, email);
    }

    @Override
    public void deleteUser(User user) {
    }

    @Override
    public void updateUserPassword(User user, String newPassword) {
        user.updatePassword(newPassword);
    }
}
