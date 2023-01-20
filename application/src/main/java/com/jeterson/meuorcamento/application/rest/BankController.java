package com.jeterson.meuorcamento.application.rest;

import com.jeterson.meuorcaento.domain.application.service.input.service.BankApplicationService;
import com.jeterson.meuorcamento.domain.core.entities.Bank;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banks")
@RequiredArgsConstructor
public class BankController {

    private final BankApplicationService bankApplicationService;

    @GetMapping
    public ResponseEntity<List<Bank>> findAll() {
        return ResponseEntity.ok(bankApplicationService.findAll());
    }
}
