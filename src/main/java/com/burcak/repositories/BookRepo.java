package com.burcak.repositories;

import com.burcak.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, String> {

    List<Book> findByNameIgnoreCaseContaining(String name);

    List<Book> findByName(String name);

    List<Book> findAllByAuthors_Name(String name);
}
