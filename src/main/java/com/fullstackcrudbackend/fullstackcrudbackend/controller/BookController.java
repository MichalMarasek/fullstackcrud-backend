package com.fullstackcrudbackend.fullstackcrudbackend.controller;

import com.fullstackcrudbackend.fullstackcrudbackend.exception.BookNotFoundException;
import com.fullstackcrudbackend.fullstackcrudbackend.model.Book;
import com.fullstackcrudbackend.fullstackcrudbackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/book")
    Book newBook(@RequestBody Book newbook) {
        return bookRepository.save(newbook);
    }

    @GetMapping("/books")
    List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException(id)
        );
    }

    @PutMapping("/book/{id}")
    Book updateBook(@RequestBody Book newBook, @PathVariable Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setAuthor(newBook.getAuthor());
                    book.setTitle(newBook.getTitle());
                    book.setDescription(newBook.getDescription());

                    return bookRepository.save(book);
                }).orElseThrow(() -> new BookNotFoundException(id));
    }

    @DeleteMapping("/book/{id}")
    String deleteBook(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }

        bookRepository.deleteById(id);
        return "Book with id: " + id + " has beed deleted.";
    }
}
