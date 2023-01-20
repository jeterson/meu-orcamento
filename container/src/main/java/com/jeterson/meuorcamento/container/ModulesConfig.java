package com.jeterson.meuorcamento.container;

import com.jeterson.meuorcamento.application.ApplicationLayer;
import com.jeterson.meuorcamento.dataaccess.DataAccessLayer;
import com.jeterson.meuorcamento.domain.application.service.DomainApplicationServiceLayer;
import com.jeterson.meuorcamento.security.SecurityLayer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SecurityLayer.class,
        DomainApplicationServiceLayer.class,
        DataAccessLayer.class,
        ApplicationLayer.class})
public class ModulesConfig {
}
