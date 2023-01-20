package com.jeterson.meuorcamento.dataaccess.account.mapper;

import com.jeterson.meuorcamento.dataaccess.account.entities.BankEntity;
import com.jeterson.meuorcamento.domain.core.entities.Bank;
import org.springframework.stereotype.Component;

@Component
public class BankDataAccessMapper {

    public Bank toBank(BankEntity bank) {
        return Bank.builder()
                .image(bank.getImage())
                .name(bank.getName())
                .id(bank.getId())
                .build();
    }
    public BankEntity toEntity(Bank bank) {
        return BankEntity.builder()
                .id(bank.getId())
                .image(bank.getImage())
                .name(bank.getName())
                .build();
    }

}
