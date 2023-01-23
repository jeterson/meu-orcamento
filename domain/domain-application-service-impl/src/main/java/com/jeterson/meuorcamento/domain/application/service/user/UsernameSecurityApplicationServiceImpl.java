package com.jeterson.meuorcamento.domain.application.service.user;

import com.jeterson.meuorcamento.domain.application.service.input.service.UsernameApplicationService;
import com.jeterson.meuorcamento.domain.application.service.output.repository.UserRepository;
import com.jeterson.meuorcamento.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("usernameSecurityApplicationService")
@RequiredArgsConstructor
public class UsernameSecurityApplicationServiceImpl implements UsernameApplicationService {

    private final UserRepository userRepository;
    @Override
    public User findByUsername(String username) {
        var user = userRepository.findByUsername(username);
        return user.get();
    }
}
