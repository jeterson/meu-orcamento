package com.jeterson.meuorcamento.dataaccess.category.repository;


import com.jeterson.meuorcamento.dataaccess.category.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
}
