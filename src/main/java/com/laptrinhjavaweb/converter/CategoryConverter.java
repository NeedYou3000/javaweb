package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public CategoryDTO toDTO(CategoryEntity e) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(e.getId());
        categoryDTO.setName(e.getName());
        categoryDTO.setCode(e.getCode());
        return categoryDTO;
    }

    public CategoryEntity toEntity(CategoryDTO e) {
        CategoryEntity category = new CategoryEntity();
        category.setName(e.getName());
        category.setCode(e.getCode());
        return category;
    }
}
