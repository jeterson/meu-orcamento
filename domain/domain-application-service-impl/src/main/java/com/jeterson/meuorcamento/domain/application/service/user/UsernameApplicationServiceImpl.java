package com.jeterson.meuorcamento.domain.application.service.user;

import com.jeterson.meuorcaento.domain.application.service.input.service.UsernameApplicationService;
import com.jeterson.meuorcaento.domain.application.service.output.repository.UserRepository;
import com.jeterson.meuorcamento.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("usernameApplicationService")
@RequiredArgsConstructor
public class UsernameApplicationServiceImpl implements UsernameApplicationService {

    private final UserRepository userRepository;
    @Override
    public User findByUsername(String username) {
        var user = userRepository.findByUsername(username);
        user.get().removePassword();
        return user.get();
    }
}
