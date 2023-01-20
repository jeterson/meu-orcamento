package com.jeterson.meuorcamento.dataaccess.user.repository;

import com.jeterson.meuorcamento.dataaccess.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
