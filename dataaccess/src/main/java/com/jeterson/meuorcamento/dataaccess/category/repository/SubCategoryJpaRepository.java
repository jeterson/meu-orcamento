package com.jeterson.meuorcamento.dataaccess.category.repository;


import com.jeterson.meuorcamento.dataaccess.category.entities.CategoryEntity;
import com.jeterson.meuorcamento.dataaccess.category.entities.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryJpaRepository extends JpaRepository<SubCategoryEntity, Long> {

    List<SubCategoryEntity> findByCategory(CategoryEntity categoryEntity);
}
