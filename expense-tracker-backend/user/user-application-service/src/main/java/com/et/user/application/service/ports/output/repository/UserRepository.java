package com.et.user.application.service.ports.output.repository;

import com.et.common.domain.valueobject.UserId;
import com.et.user.domain.entity.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);
    Optional<User> findUserById(UserId userId);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
}
