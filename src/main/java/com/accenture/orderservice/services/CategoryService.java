package com.accenture.orderservice.services;

import com.accenture.orderservice.domains.Category;
import com.accenture.orderservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(Category category) throws Exception {
        categoryRepository.save(category);
        return category;
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category findById(Long id) {
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    private Category updateById(Long id, Category category) throws Exception {
        category.setId(id);
        categoryRepository.save(category);
        return category;
    }

    private List<Category> findAll() {

        return categoryRepository.findAll();
    }
}


