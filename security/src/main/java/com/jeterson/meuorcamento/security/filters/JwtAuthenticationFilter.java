package com.jeterson.meuorcamento.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeterson.meuorcamento.security.dto.CredentialsDTO;
import com.jeterson.meuorcamento.security.dto.TokenResponse;
import com.jeterson.meuorcamento.security.models.UserDetailsData;
import com.jeterson.meuorcamento.security.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{
            var  credentials = new ObjectMapper()
                    .readValue(request.getInputStream(), CredentialsDTO.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    credentials.getUsername(),
                    credentials.getPassword(),
                    new ArrayList<>()
            ));
        }catch (Exception ex){
            throw new BadCredentialsException(ex.getMessage(), ex);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        var userDetailsData = (UserDetailsData) authResult.getPrincipal();
        var token = JwtUtils.getInstance().generateToken(userDetailsData);
        var tokenResponse = new TokenResponse(token, userDetailsData.getName(),userDetailsData.getUsername());
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(tokenResponse));
        response.getWriter().flush();
    }
}
