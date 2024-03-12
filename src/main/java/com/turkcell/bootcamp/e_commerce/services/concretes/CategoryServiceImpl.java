package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.core.exception.types.BusinessException;
import com.turkcell.bootcamp.e_commerce.core.services.constants.Messages;
import com.turkcell.bootcamp.e_commerce.entities.Category;
import com.turkcell.bootcamp.e_commerce.repositories.CategoryRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.CategoryService;
import com.turkcell.bootcamp.e_commerce.services.dtos.category.requests.AddCategoryRequest;
import com.turkcell.bootcamp.e_commerce.services.mappers.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public void add(AddCategoryRequest request) throws Exception {
        categoryWithSameNameShouldNotExist(request.getName());

        Category category = CategoryMapper.INSTANCE.categoryFromAddCategoryRequest(request);
        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new BusinessException(Messages.BusinessErrors.NOT_FOUND_ERROR);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new BusinessException(Messages.BusinessErrors.NOT_FOUND_ERROR);
        }
        return categoryRepository.findById(id).get();
    }

    public boolean isIdExist(int id) {
        return categoryRepository.existsById(id);
    }

    public void categoryWithSameNameShouldNotExist(String name) throws Exception {
        Optional<Category> category = categoryRepository.findByName(name);
        if (category.isPresent()) {
            throw new BusinessException(Messages.BusinessErrors.SAME_CATEGORY_NAME_ERROR);
        }
    }
}
