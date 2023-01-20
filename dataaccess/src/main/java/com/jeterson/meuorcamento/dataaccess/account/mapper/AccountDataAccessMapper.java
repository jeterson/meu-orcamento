package com.jeterson.meuorcamento.dataaccess.account.mapper;

import com.jeterson.meuorcamento.common.domain.valueobjects.Money;
import com.jeterson.meuorcamento.dataaccess.account.entities.AccountEntity;
import com.jeterson.meuorcamento.dataaccess.user.mapper.UserDataAccessMapper;
import com.jeterson.meuorcamento.domain.core.entities.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;
    private final BankDataAccessMapper bankDataAccessMapper;

    public Account toAccount(AccountEntity accountEntity) {
        var user = userDataAccessMapper.toUser(accountEntity.getUser());
        user.removePassword();
        return Account.builder()
                .bank(bankDataAccessMapper.toBank(accountEntity.getBank()))
                .user(user)
                .balance(new Money(accountEntity.getBalance()))
                .name(accountEntity.getName())
                .type(accountEntity.getType())
                .id(accountEntity.getId())
                .color(accountEntity.getColor())
                .build();
    }
    public AccountEntity toEntity(Account account) {
        return AccountEntity.builder()
                .bank(bankDataAccessMapper.toEntity(account.getBank()))
                .id(account.getId())
                .balance(account.getBalance().getAmount())
                .name(account.getName())
                .type(account.getType())
                .color(account.getColor())
                .user(userDataAccessMapper.toEntity(account.getUser()))
                .build();
    }
}
