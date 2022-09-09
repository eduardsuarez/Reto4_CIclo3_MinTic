/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto4.Reto4.service;


import com.Reto4.Reto4.entity.Category;
import com.Reto4.Reto4.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getCategories() {
        return repository.findAll();
    }

    public Category getCategoryById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Category saveCategory(Category category) {
        return repository.save(category);
    }
    public Category updatCategory(Category category){
        Category existeCategory = getCategoryById(category.getId());
        //existeCategory.setId(category.getId());
        existeCategory.setName(category.getName());
        existeCategory.setDescription(category.getDescription());
        return repository.save(existeCategory);
    }
    
    public void deleteCategory(int id){
        repository.deleteById(id);
    }

}
