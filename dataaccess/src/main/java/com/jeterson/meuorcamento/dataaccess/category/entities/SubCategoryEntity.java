package com.jeterson.meuorcamento.dataaccess.category.entities;

import com.jeterson.meuorcamento.domain.core.valueobjects.Color;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mo_subcategory")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class SubCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
