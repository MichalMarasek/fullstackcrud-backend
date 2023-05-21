package com.fullstackcrudbackend.fullstackcrudbackend.repository;

import com.fullstackcrudbackend.fullstackcrudbackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
