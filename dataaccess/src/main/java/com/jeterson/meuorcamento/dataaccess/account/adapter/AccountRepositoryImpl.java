package com.jeterson.meuorcamento.dataaccess.account.adapter;

import com.jeterson.meuorcaento.domain.application.service.output.repository.AccountRepository;
import com.jeterson.meuorcamento.dataaccess.account.mapper.AccountDataAccessMapper;
import com.jeterson.meuorcamento.dataaccess.account.repository.AccountJpaRepository;
import com.jeterson.meuorcamento.dataaccess.user.mapper.UserDataAccessMapper;
import com.jeterson.meuorcamento.domain.core.entities.Account;
import com.jeterson.meuorcamento.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountDataAccessMapper accountDataAccessMapper;
    private final AccountJpaRepository accountJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    @Override
    public List<Account> findAll(User user) {
        var accounts = accountJpaRepository.findByUser(userDataAccessMapper.toEntity(user));
        return accounts.stream().map(accountDataAccessMapper::toAccount).collect(Collectors.toList());
    }

    @Override
    public Optional<Account> findById(Long id, User user) {
        return accountJpaRepository
                .findByUserAndId(userDataAccessMapper.toEntity(user), id)
                .map(accountDataAccessMapper::toAccount);
    }

    @Override
    public Account save(Account account) {
        var entity = accountDataAccessMapper.toEntity(account);
        return accountDataAccessMapper.toAccount(accountJpaRepository.save(entity));
    }
}
