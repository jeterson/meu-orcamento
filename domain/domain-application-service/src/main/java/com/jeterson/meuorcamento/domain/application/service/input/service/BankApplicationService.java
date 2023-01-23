package com.jeterson.meuorcamento.domain.application.service.input.service;

import com.jeterson.meuorcamento.domain.core.entities.Bank;

import java.util.List;

public interface BankApplicationService {

    Bank create(Bank bank);
    List<Bank> findAll();
    Bank findById(Long id);
    Bank findByName(String name);
}
