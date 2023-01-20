package com.jeterson.meuorcamento.application.rest;

import com.jeterson.meuorcaento.domain.application.service.dto.account.CreateAccountCommand;
import com.jeterson.meuorcaento.domain.application.service.dto.account.UpdateAccountCommand;
import com.jeterson.meuorcaento.domain.application.service.input.service.AccountApplicationService;
import com.jeterson.meuorcamento.domain.core.entities.Account;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountApplicationService accountApplicationService;

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        var list = accountApplicationService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        var obj = accountApplicationService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Account> create(@Valid @RequestBody CreateAccountCommand createAccountCommand) {
        var account = accountApplicationService.create(createAccountCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }
    @PutMapping
    public ResponseEntity<Account> update(@RequestBody UpdateAccountCommand updateAccountCommand) {
        var account = accountApplicationService.update(updateAccountCommand);
        return ResponseEntity.ok(account);
    }

}
