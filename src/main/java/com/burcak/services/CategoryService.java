package com.burcak.services;

import com.burcak.entities.Category;
import com.burcak.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void categoryOperations() {

        Category c1 = new Category();
        c1.setName("Computer Science");
        categoryRepo.save(c1);

        Category c2 = new Category();
        c2.setName("Novel");
        categoryRepo.save(c2);

    }
}
