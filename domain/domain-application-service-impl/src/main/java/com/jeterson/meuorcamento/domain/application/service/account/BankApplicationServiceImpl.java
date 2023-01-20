package com.jeterson.meuorcamento.domain.application.service.account;

import com.jeterson.meuorcaento.domain.application.service.input.service.BankApplicationService;
import com.jeterson.meuorcaento.domain.application.service.output.repository.BankRepository;
import com.jeterson.meuorcamento.domain.core.entities.Bank;
import com.jeterson.meuorcamento.domain.core.exceptions.bank.BankNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankApplicationServiceImpl implements BankApplicationService {

    private final BankRepository bankRepository;

    @Override
    public Bank create(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    public Bank findById(Long id){
        var bank = bankRepository.findById(id);
        if(bank.isEmpty())
            throw new BankNotFoundException(id);

        return bank.get();
    }

    @Override
    public Bank findByName(String name) {
        var bank = bankRepository.findByName(name);
        if(bank.isEmpty())
            throw new BankNotFoundException("Bank with name " + name + " not found");

        return bank.get();
    }
}
