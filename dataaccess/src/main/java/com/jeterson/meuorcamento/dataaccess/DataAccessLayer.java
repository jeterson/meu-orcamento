package com.jeterson.meuorcamento.dataaccess;

import com.jeterson.meuorcaento.domain.application.service.dto.user.CreateUserCommand;
import com.jeterson.meuorcaento.domain.application.service.input.service.BankApplicationService;
import com.jeterson.meuorcaento.domain.application.service.input.service.SecurityService;
import com.jeterson.meuorcaento.domain.application.service.input.service.UserApplicationService;
import com.jeterson.meuorcamento.domain.core.entities.Bank;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.jeterson.meuorcamento.dataaccess"})
@EntityScan(basePackages = {"com.jeterson.meuorcamento.dataaccess"})
@ComponentScan(basePackages = {"com.jeterson.meuorcamento.dataaccess"})
@RequiredArgsConstructor
public class DataAccessLayer {

    private final UserApplicationService userApplicationService;
    private final SecurityService securityService;
    private final BankApplicationService bankApplicationService;

    @PostConstruct
    public void start() {
    }
}
