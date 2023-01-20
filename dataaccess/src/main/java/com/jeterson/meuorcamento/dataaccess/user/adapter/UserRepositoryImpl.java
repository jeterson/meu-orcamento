package com.jeterson.meuorcamento.dataaccess.user.adapter;

import com.jeterson.meuorcaento.domain.application.service.output.repository.UserRepository;
import com.jeterson.meuorcamento.dataaccess.user.mapper.UserDataAccessMapper;
import com.jeterson.meuorcamento.dataaccess.user.repository.UserJpaRepository;
import com.jeterson.meuorcamento.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    @Override
    public Optional<User> findByUsername(String username) {
        return userJpaRepository.findByUsername(username).map(userDataAccessMapper::toUser);
    }

    @Override
    public User save(User user) {
       return userDataAccessMapper.toUser(userJpaRepository.save(userDataAccessMapper.toEntity(user)));
    }

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id).map(userDataAccessMapper::toUser);
    }

}
