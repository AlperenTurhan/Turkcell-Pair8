package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.entities.Category;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.CategoryRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void add(Category category) throws Exception {
        if(isIdExist(category.getId())){
            throw new Exception("This category is already exist.");
        }


        categoryRepository.add(category);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such a category");
        }
        categoryRepository.delete(id);
    }

    @Override
    public void update(Category category) throws Exception {
        if (!isIdExist(category.getId())) {
            throw new Exception("There is no such an id");
        }
        categoryRepository.update(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public Category getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such a category");
        }
        return categoryRepository.getById(id);
    }
    public boolean isIdExist(int id) {
        for (Category category : getAll()) {
            if (category.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
