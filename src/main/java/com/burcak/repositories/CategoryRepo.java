package com.burcak.repositories;

import com.burcak.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {

    Category findByName(String name);
}
