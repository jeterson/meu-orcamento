package com.jeterson.meuorcamento.dataaccess.user.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mo_user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
}
