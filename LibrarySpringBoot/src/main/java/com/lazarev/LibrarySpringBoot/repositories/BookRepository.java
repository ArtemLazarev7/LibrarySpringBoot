package com.lazarev.LibrarySpringBoot.repositories;


import com.lazarev.LibrarySpringBoot.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByTitleStartingWith(String title);




}
