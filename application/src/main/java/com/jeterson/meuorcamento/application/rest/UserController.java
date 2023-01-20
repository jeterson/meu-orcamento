package com.jeterson.meuorcamento.application.rest;

import com.jeterson.meuorcaento.domain.application.service.dto.user.CreateUserCommand;
import com.jeterson.meuorcaento.domain.application.service.dto.user.UpdateUserCommand;
import com.jeterson.meuorcaento.domain.application.service.input.service.UserApplicationService;
import com.jeterson.meuorcamento.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody CreateUserCommand createUserCommand) {
        var createdUser = userApplicationService.create(createUserCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @PutMapping
    public ResponseEntity<User> update(@RequestBody UpdateUserCommand updateUserCommand) {
        var createdUser = userApplicationService.update(updateUserCommand);
        return ResponseEntity.ok(createdUser);
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username){
        var user = userApplicationService.findByUsername(username);
        return ResponseEntity.ok(user);
    }
}
