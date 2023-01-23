package com.jeterson.meuorcamento.domain.core.entities;

import com.jeterson.meuorcamento.domain.core.entities.base.CategoryBase;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SubCategory extends CategoryBase {

    private Category category;
}
