package com.jeterson.meuorcamento.domain.core.entities;

import com.jeterson.meuorcamento.domain.core.entities.base.CategoryBase;
import com.jeterson.meuorcamento.domain.core.valueobjects.Color;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
public class Category extends CategoryBase {

    private Color color = Color.BLACK;
    private List<SubCategory> subCategories = new ArrayList<>();
}
