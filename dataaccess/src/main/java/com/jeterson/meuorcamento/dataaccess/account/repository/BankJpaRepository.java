package com.jeterson.meuorcamento.dataaccess.account.repository;

import com.jeterson.meuorcamento.dataaccess.account.entities.BankEntity;
import com.jeterson.meuorcamento.domain.core.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankJpaRepository extends JpaRepository<BankEntity, Long> {
    Optional<BankEntity> findByNameIgnoreCase(String name);
}
