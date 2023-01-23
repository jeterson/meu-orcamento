package com.jeterson.meuorcamento.dataaccess.category.mapper;

import com.jeterson.meuorcamento.dataaccess.category.entities.CategoryEntity;
import com.jeterson.meuorcamento.dataaccess.category.entities.SubCategoryEntity;
import com.jeterson.meuorcamento.domain.core.entities.Category;
import com.jeterson.meuorcamento.domain.core.entities.SubCategory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryDataAccessMapper {

    public CategoryEntity toCategoryEntity(Category category) {
        if(category == null)
            return null;

        var subcategories = category
                .getSubCategories()
                .stream()
                .map(this::toSubCategoryEntity)
                .collect(Collectors.toList());

        return CategoryEntity.builder()
                .id(category.getId())
                .color(category.getColor())
                .name(category.getName())
                .subCategories(subcategories)
                .build();
    }
    public SubCategoryEntity toSubCategoryEntity(SubCategory subCategory){
        return SubCategoryEntity.builder()
                .id(subCategory.getId())
                .name(subCategory.getName())
                .category(toCategoryEntity(subCategory.getCategory()))
                .build();
    }

    public Category toCategory(CategoryEntity categoryEntity) {
        var subcategories = categoryEntity
                .getSubCategories()
                .stream().map(this::toSubCategory)
                .collect(Collectors.toList());

        return Category.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .color(categoryEntity.getColor())
                .subCategories(subcategories)
                .build();
    }
    public SubCategory toSubCategory(SubCategoryEntity subCategoryEntity){
        return SubCategory.builder()
                .category(toCategory(subCategoryEntity.getCategory()))
                .id(subCategoryEntity.getId())
                .name(subCategoryEntity.getName())
                .build();
    }
}
