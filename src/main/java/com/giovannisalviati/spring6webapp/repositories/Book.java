package com.giovannisalviati.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

public interface Book extends CrudRepository<Book, Long> {
}
