package com.jeterson.meuorcamento.dataaccess;

import com.jeterson.meuorcamento.domain.application.service.input.service.BankApplicationService;
import com.jeterson.meuorcamento.domain.application.service.input.service.SecurityApplicationService;
import com.jeterson.meuorcamento.domain.application.service.input.service.UserApplicationService;
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
    private final SecurityApplicationService securityApplicationService;
    private final BankApplicationService bankApplicationService;

    @PostConstruct
    public void start() {
    }
}
