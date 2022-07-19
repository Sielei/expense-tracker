package com.et.backend.data.access.user.adapter;

import com.et.backend.data.access.user.entity.UserEntity;
import com.et.backend.data.access.user.mapper.UserEntityDataMapper;
import com.et.backend.data.access.user.repository.UserJpaRepository;
import com.et.common.domain.valueobject.UserId;
import com.et.user.application.service.ports.output.repository.UserRepository;
import com.et.user.domain.entity.User;
import com.et.user.domain.exception.UserDomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserEntityDataMapper userEntityDataMapper;
    @Override
    public User save(User user) {
        UserEntity userEntity = userEntityDataMapper.userToUserEntity(user);
        UserEntity newUserEntity = userJpaRepository.save(userEntity);
        return userEntityDataMapper.userEntityToUser(newUserEntity);
    }

    @Override
    public Optional<User> findUserById(UserId userId) {
        Optional<UserEntity> userEntityOptional = userJpaRepository.findById(userId.getValue());
        if (userEntityOptional.isEmpty()){
            throw new UserDomainException("No user exists with id: " + userId.getValue());
        }
        return Optional.ofNullable(userEntityDataMapper.userEntityToUser(userEntityOptional.get()));
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        Optional<UserEntity> userEntityOptional = userJpaRepository.findByUsername(username);
        if (userEntityOptional.isEmpty()){
            throw new UserDomainException("No user exists with username: " + username);
        }
        return Optional.ofNullable(userEntityDataMapper.userEntityToUser(userEntityOptional.get()));
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = userEntityDataMapper.userToUserEntity(user);
        return userEntityDataMapper.userEntityToUser(userJpaRepository.save(userEntity));
    }

    @Override
    public User updatePassword(User user) {
        UserEntity userEntity = userEntityDataMapper.userToUserEntity(user);
        return userEntityDataMapper.userEntityToUser(userJpaRepository.save(userEntity));
    }
}
