package com.et.user.domain.entity;

import com.et.common.domain.entity.AggregateRoot;
import com.et.common.domain.valueobject.UserId;

import java.util.UUID;

public class User extends AggregateRoot<UserId> {

    private final String username;
    private final String email;
    private final String password;

    private User(Builder builder) {
        super.setId(builder.userId);
        username = builder.username;
        email = builder.email;
        password = builder.password;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void createUser(){
        setId(new UserId(UUID.randomUUID()));
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public static final class Builder {
        private UserId userId;
        private String username;
        private String email;
        private String password;

        private Builder() {
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
