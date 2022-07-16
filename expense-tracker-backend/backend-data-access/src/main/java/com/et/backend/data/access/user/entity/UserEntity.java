package com.et.backend.data.access.user.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    private String username;
    private String email;
    private String password;

}