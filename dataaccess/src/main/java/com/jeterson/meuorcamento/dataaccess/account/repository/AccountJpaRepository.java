package com.jeterson.meuorcamento.dataaccess.account.repository;

import com.jeterson.meuorcamento.dataaccess.account.entities.AccountEntity;
import com.jeterson.meuorcamento.dataaccess.user.entities.UserEntity;
import com.jeterson.meuorcamento.domain.core.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findByUser(UserEntity user);
    Optional<AccountEntity> findByUserAndId(UserEntity user, Long id);
}
