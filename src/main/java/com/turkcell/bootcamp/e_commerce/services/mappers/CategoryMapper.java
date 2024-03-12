package com.turkcell.bootcamp.e_commerce.services.mappers;

import com.turkcell.bootcamp.e_commerce.entities.Category;
import com.turkcell.bootcamp.e_commerce.services.dtos.category.requests.AddCategoryRequest;
import org.mapstruct.factory.Mappers;

public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryFromAddCategoryRequest(AddCategoryRequest request);
}
