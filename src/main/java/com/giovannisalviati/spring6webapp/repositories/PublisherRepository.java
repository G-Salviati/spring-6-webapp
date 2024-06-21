package com.giovannisalviati.spring6webapp.repositories;

import com.giovannisalviati.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
