package com.jeterson.meuorcamento.dataaccess.account.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "mo_bank")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String image;
}
