package com.et.backend.data.access.user.mapper;

import com.et.backend.data.access.user.entity.UserEntity;
import com.et.common.domain.valueobject.UserId;
import com.et.user.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityDataMapper {
    public UserEntity userToUserEntity(User user) {
        return UserEntity
                .builder()
                .id(user.getId().getValue())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public User userEntityToUser(UserEntity userEntity) {
        return User
                .builder()
                .userId(new UserId(userEntity.getId()))
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .build();
    }
}
