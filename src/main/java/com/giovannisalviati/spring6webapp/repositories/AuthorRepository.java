package com.giovannisalviati.spring6webapp.repositories;

import com.giovannisalviati.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
