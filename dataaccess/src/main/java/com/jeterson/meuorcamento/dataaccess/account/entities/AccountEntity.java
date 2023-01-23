package com.jeterson.meuorcamento.dataaccess.account.entities;

import com.jeterson.meuorcamento.dataaccess.user.entities.UserEntity;
import com.jeterson.meuorcamento.domain.core.valueobjects.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "mo_account")
@Entity
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankEntity bank;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Enumerated(EnumType.STRING)
    private AccountColor color;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    private BigDecimal balance;
}
