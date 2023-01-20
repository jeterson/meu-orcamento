package com.jeterson.meuorcamento.dataaccess.account.adapter;

import com.jeterson.meuorcaento.domain.application.service.output.repository.BankRepository;
import com.jeterson.meuorcamento.dataaccess.account.mapper.BankDataAccessMapper;
import com.jeterson.meuorcamento.dataaccess.account.repository.BankJpaRepository;
import com.jeterson.meuorcamento.domain.core.entities.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BankRepositoryImpl implements BankRepository {

    private final BankJpaRepository bankJpaRepository;
    private final BankDataAccessMapper bankDataAccessMapper;

    @Override
    public Bank save(Bank bank) {
        return bankDataAccessMapper.toBank(bankJpaRepository.save(bankDataAccessMapper.toEntity(bank)));
    }

    @Override
    public List<Bank> findAll() {
        return bankJpaRepository.findAll()
                .stream()
                .map(bankDataAccessMapper::toBank)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Bank> findById(Long id) {
        return bankJpaRepository.findById(id).map(bankDataAccessMapper::toBank);
    }

    @Override
    public Optional<Bank> findByName(String name) {
        return bankJpaRepository.findByNameIgnoreCase(name).map(bankDataAccessMapper::toBank);
    }
}
