package com.turkcell.bootcamp.e_commerce.repositories.concretes;

import com.turkcell.bootcamp.e_commerce.entities.Category;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    List<Category> categories;
    public CategoryRepositoryImpl(){
        categories = new ArrayList<Category>();
    }
    @Override
    public void add(Category category) {
        categories.add(category);
    }

    @Override
    public void delete(int id) {
        categories.remove(getById(id));
    }

    @Override
    public void update(Category category) {
        Category oldCategory = getById(category.getId());
        oldCategory.setName(category.getName());
        oldCategory.setDescription(category.getDescription());
    }

    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Category getById(int id) {
        for(Category category: categories){
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }
}
