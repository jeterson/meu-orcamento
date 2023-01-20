package com.jeterson.meuorcamento.domain.application.service.account;

import com.jeterson.meuorcaento.domain.application.service.dto.account.CreateAccountCommand;
import com.jeterson.meuorcaento.domain.application.service.dto.account.UpdateAccountCommand;
import com.jeterson.meuorcaento.domain.application.service.input.service.AccountApplicationService;
import com.jeterson.meuorcaento.domain.application.service.input.service.BankApplicationService;
import com.jeterson.meuorcaento.domain.application.service.input.service.SecurityService;
import com.jeterson.meuorcaento.domain.application.service.output.repository.AccountRepository;
import com.jeterson.meuorcaento.domain.application.service.output.repository.BankRepository;
import com.jeterson.meuorcamento.common.domain.valueobjects.Money;
import com.jeterson.meuorcamento.domain.core.entities.Account;
import com.jeterson.meuorcamento.domain.core.entities.Bank;
import com.jeterson.meuorcamento.domain.core.entities.User;
import com.jeterson.meuorcamento.domain.core.exceptions.account.AccountDomainException;
import com.jeterson.meuorcamento.domain.core.exceptions.account.AccountNotFoundException;
import com.jeterson.meuorcamento.domain.core.valueobjects.AccountType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountApplicationServiceImpl implements AccountApplicationService {

    private final SecurityService securityService;
    private final BankApplicationService bankApplicationService;
    private final AccountRepository accountRepository;

    @Override
    public Account create(@Valid CreateAccountCommand createAccountCommand) {
        var account = createWithUser(createAccountCommand, null);
        return accountRepository.save(account);
    }

    @Override
    public Account createWithUser(CreateAccountCommand createAccountCommand, User user) {
        var bank = bankApplicationService.findById(createAccountCommand.getBankId());
        if(user == null)
            user = securityService.getAuthenticatedUser();

        var account = Account.builder()
                .type(createAccountCommand.getAccountType())
                .name(createAccountCommand.getName())
                .user(user)
                .balance(new Money(createAccountCommand.getBalance()))
                .bank(bank)
                .color(createAccountCommand.getAccountColor())
                .build();
        account = accountRepository.save(account);
        return account;
    }

    @Override
    public Account update(UpdateAccountCommand updateAccountCommand) {
        var bank = bankApplicationService.findById(updateAccountCommand.getBankId());
        var user = securityService.getAuthenticatedUser();

        if(accountRepository.findById(updateAccountCommand.getId(), user).isEmpty())
            throw new AccountNotFoundException(updateAccountCommand.getId(), user);

        var account = Account.builder()
                .id(updateAccountCommand.getId())
                .type(updateAccountCommand.getAccountType())
                .name(updateAccountCommand.getName())
                .user(user)
                .bank(bank)
                .color(updateAccountCommand.getAccountColor())
                .build();

        return accountRepository.save(account);
    }

    @Override
    public Account findById(Long id) {
        var user = securityService.getAuthenticatedUser();
        var account = accountRepository.findById(id, user);

        if(account.isEmpty())
            throw new AccountNotFoundException(id, user);

        return account.get();
    }

    @Override
    public List<Account> findAll() {
        var user = securityService.getAuthenticatedUser();
        return accountRepository.findAll(user);
    }
}
