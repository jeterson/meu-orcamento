package com.jeterson.meuorcamento.application.rest;

import com.jeterson.meuorcaento.domain.application.service.dto.auth.TokenValidResponse;
import com.jeterson.meuorcaento.domain.application.service.input.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SecurityService securityService;

    @GetMapping("/validate-token")
    public ResponseEntity<TokenValidResponse> validateToken(@RequestParam(name = "token") String token) {
        var isTokenValid = securityService.isTokenValid(token);
        return ResponseEntity.ok(new TokenValidResponse(isTokenValid));
    }
}
