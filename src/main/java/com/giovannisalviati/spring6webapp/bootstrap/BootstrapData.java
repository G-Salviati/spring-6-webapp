package com.giovannisalviati.spring6webapp.bootstrap;

import com.giovannisalviati.spring6webapp.domain.Author;
import com.giovannisalviati.spring6webapp.domain.Book;
import com.giovannisalviati.spring6webapp.repositories.AuthorRepository;
import com.giovannisalviati.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author nora = new Author();
        nora.setFirstName("Nora");
        nora.setLastName("Ephron");

        Book iFeelBadAboutMyNeck = new Book();
        iFeelBadAboutMyNeck.setTitle("I Feel Bad About My Neck");
        iFeelBadAboutMyNeck.setIsbn("000000");

        Author noraSaved = authorRepository.save(nora);
        Book iFeelBadAboutMyNeckSaved = bookRepository.save(iFeelBadAboutMyNeck);


        Author stieg = new Author();
        stieg.setFirstName("Stieg");
        stieg.setLastName("Larsson");

        Book theGirlWithTheDragonTatoo = new Book();
        theGirlWithTheDragonTatoo.setTitle("The Girl With The Dragon Tatoo");
        theGirlWithTheDragonTatoo.setIsbn("000001");

        Author stiegSaved = authorRepository.save(stieg);
        Book theGirlWithTheDragonTatooSaved = bookRepository.save(theGirlWithTheDragonTatoo);


//      association between authors and books
        noraSaved.getBooks().add(iFeelBadAboutMyNeckSaved);
        stiegSaved.getBooks().add(theGirlWithTheDragonTatooSaved);

        authorRepository.save(noraSaved);
        authorRepository.save(stiegSaved);

        System.out.println("in bootstrap!");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
