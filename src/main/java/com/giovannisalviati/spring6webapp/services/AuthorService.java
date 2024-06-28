package com.giovannisalviati.spring6webapp.services;

import com.giovannisalviati.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
