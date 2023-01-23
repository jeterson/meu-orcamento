package com.jeterson.meuorcamento.domain.application.service.output.repository;

import com.jeterson.meuorcamento.domain.core.entities.Bank;

import java.util.List;
import java.util.Optional;

public interface BankRepository {
    Bank save(Bank bank);
    List<Bank> findAll();
    Optional<Bank> findById(Long id);
    Optional<Bank> findByName(String name);

}
