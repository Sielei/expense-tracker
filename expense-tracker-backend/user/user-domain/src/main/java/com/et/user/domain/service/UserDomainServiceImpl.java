package com.et.user.domain.service;

import com.et.user.domain.entity.User;

public class UserDomainServiceImpl implements UserDomainService{
    @Override
    public void createUser(User user) {
        user.createUser();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
