package com.jeterson.meuorcamento.domain.application.service.user;

import com.jeterson.meuorcamento.domain.application.service.dto.account.CreateAccountCommand;
import com.jeterson.meuorcamento.domain.application.service.dto.user.CreateUserCommand;
import com.jeterson.meuorcamento.domain.application.service.dto.user.UpdateUserCommand;
import com.jeterson.meuorcamento.domain.application.service.input.service.AccountApplicationService;
import com.jeterson.meuorcamento.domain.application.service.input.service.BankApplicationService;
import com.jeterson.meuorcamento.domain.application.service.input.service.SecurityApplicationService;
import com.jeterson.meuorcamento.domain.application.service.input.service.UserApplicationService;
import com.jeterson.meuorcamento.domain.application.service.output.repository.UserRepository;
import com.jeterson.meuorcamento.common.domain.valueobjects.Money;
import com.jeterson.meuorcamento.domain.application.service.user.mapper.UserDataMapper;
import com.jeterson.meuorcamento.domain.core.entities.User;
import com.jeterson.meuorcamento.domain.core.exceptions.user.UserNotFoundException;
import com.jeterson.meuorcamento.domain.core.valueobjects.AccountType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserRepository userRepository;
    private final SecurityApplicationService securityApplicationService;
    private final UserDataMapper userDataMapper;
    private final BankApplicationService bankApplicationService;
    private final AccountApplicationService accountApplicationService;

    @Override
    public User create(@Valid CreateUserCommand createUserCommand) {
        var user = userDataMapper.createUserCommandToUser(createUserCommand);

        user.setPassword(securityApplicationService.encode(user.getPassword()));
        user = userRepository.save(user);
        user.removePassword();
        var account = CreateAccountCommand.builder()
                .name("Carteira")
                .accountType(AccountType.CARTEIRA)
                .balance(Money.ZERO.getAmount())
                .bankId(bankApplicationService.findByName("carteira").getId())
                .build();
        accountApplicationService.createWithUser(account, user);
        return user;
    }

    @Override
    public User update(@Valid UpdateUserCommand updateUserCommand) {
        var userAux = userRepository.findById(updateUserCommand.getId());

        if(userAux.isEmpty())
            throw new UserNotFoundException(String.format("User with id %s not found", updateUserCommand.getId()));

        var user = userDataMapper.updateUserCommandToUser(updateUserCommand, userAux.get());

        if(user.getPassword() == null || user.getPassword().isEmpty() || user.getPassword().isBlank())
            user.setPassword(userAux.get().getPassword());
        else if(user.getPassword() != userAux.get().getPassword())
            user.setPassword(securityApplicationService.encode(user.getPassword()));
       user = userRepository.save(user);
       user.removePassword();
       return user;
    }

    @Override
    public User findByUsername(String username) {
        var user = userRepository.findByUsername(username);
        if(user.isEmpty())
            throw new UserNotFoundException(String.format("User with username %s not found", username));

        user.get().removePassword();
        return user.get();
    }
}
