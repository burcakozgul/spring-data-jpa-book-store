package com.burcak.services;

import com.burcak.entities.Book;
import com.burcak.entities.Category;
import com.burcak.repositories.AuthorRepo;
import com.burcak.repositories.BookRepo;
import com.burcak.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
@Transactional
public class BookService {
    private final BookRepo bookRepo;

    private final CategoryRepo categoryRepo;

    private final AuthorRepo authorRepo;

    public BookService(BookRepo bookRepo, CategoryRepo categoryRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
        this.authorRepo = authorRepo;
    }

    public void bookOperations() {

        Category c1 = categoryRepo.findByName("Computer Science");
        Category c2 = categoryRepo.findByName("Novel");
        Book b1 = new Book();
        b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Spring in Action");
        b1.setAddedDate(LocalDate.now());
        b1.setCurrency("TL");
        b1.setDescription("Spring Framework");
        b1.setImageUrl("image1.jpg");
        b1.setPrice(100.5);
        b1.setPublishedDate(LocalDate.of(2005,5,5));
        b1.setCategory(c1);
        bookRepo.save(b1);

        Book b2 = new Book();
        b2.setIsbn(UUID.randomUUID().toString());
        b2.setName("Modular Java");
        b2.setAddedDate(LocalDate.now());
        b2.setCurrency("TL");
        b2.setDescription("Java");
        b2.setImageUrl("image2.jpg");
        b2.setPrice(120.6);
        b2.setPublishedDate(LocalDate.of(2009,9,9));
        b2.setCategory(c1);
        bookRepo.save(b2);

        Book b3 = new Book();
        b3.setIsbn(UUID.randomUUID().toString());
        b3.setName("Kurk Mantolu Madonna");
        b3.setAddedDate(LocalDate.now());
        b3.setCurrency("TL");
        b3.setDescription("Madonna");
        b3.setImageUrl("image3.jpg");
        b3.setPrice(30.3);
        b3.setPublishedDate(LocalDate.of(1943,1,1));
        b3.setCategory(c2);
        bookRepo.save(b3);
    }
    public void findByBookName(){
        List<Book> books = bookRepo.findByNameIgnoreCaseContaining("spring");
        System.out.println("Books including 'spring' word: ");
        System.out.println(books);

        List<Book> books1 = bookRepo.findAllByAuthors_Name("Sabahattin Ali");
        System.out.println("Sabahattin Ali's books: ");
        System.out.println(books1);
    }

}
