package com.jeterson.meuorcamento.security.services;

import com.jeterson.meuorcamento.domain.application.service.input.service.UsernameApplicationService;
import com.jeterson.meuorcamento.security.models.UserDetailsData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Qualifier("usernameSecurityApplicationService")
    private final UsernameApplicationService usernameSecurityApplicationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = usernameSecurityApplicationService.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException("User not found with username " + username);

        return new UserDetailsData(user);
    }
}
