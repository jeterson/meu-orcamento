package com.jeterson.meuorcamento.dataaccess.category.entities;

import com.jeterson.meuorcamento.domain.core.valueobjects.Color;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mo_category")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Color color;
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<SubCategoryEntity> subCategories = new ArrayList<>();
}
