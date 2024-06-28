package com.giovannisalviati.spring6webapp.services;

import com.giovannisalviati.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}

