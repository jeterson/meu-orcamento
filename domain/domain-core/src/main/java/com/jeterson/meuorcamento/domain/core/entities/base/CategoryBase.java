package com.jeterson.meuorcamento.domain.core.entities.base;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class CategoryBase {
    private Long id;
    private String name;
}
