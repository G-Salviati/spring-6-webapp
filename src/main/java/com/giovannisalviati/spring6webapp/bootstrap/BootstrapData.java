package com.giovannisalviati.spring6webapp.bootstrap;

import com.giovannisalviati.spring6webapp.domain.Author;
import com.giovannisalviati.spring6webapp.domain.Book;
import com.giovannisalviati.spring6webapp.domain.Publisher;
import com.giovannisalviati.spring6webapp.repositories.AuthorRepository;
import com.giovannisalviati.spring6webapp.repositories.BookRepository;
import com.giovannisalviati.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author nora = new Author();
        nora.setFirstName("Nora");
        nora.setLastName("Ephron");

        Book iFeelBadAboutMyNeck = new Book();
        iFeelBadAboutMyNeck.setTitle("I Feel Bad About My Neck");
        iFeelBadAboutMyNeck.setIsbn("000000");

        Author stieg = new Author();
        stieg.setFirstName("Stieg");
        stieg.setLastName("Larsson");

        Book theGirlWithTheDragonTatoo = new Book();
        theGirlWithTheDragonTatoo.setTitle("The Girl With The Dragon Tatoo");
        theGirlWithTheDragonTatoo.setIsbn("000001");

//        persist authors in the database
        Author noraSaved = authorRepository.save(nora);
        Author stiegSaved = authorRepository.save(stieg);

//        persist books in the database
        Book iFeelBadAboutMyNeckSaved = bookRepository.save(iFeelBadAboutMyNeck);
        Book theGirlWithTheDragonTatooSaved = bookRepository.save(theGirlWithTheDragonTatoo);


//        association between authors and books
        noraSaved.getBooks().add(iFeelBadAboutMyNeckSaved);
        stiegSaved.getBooks().add(theGirlWithTheDragonTatooSaved);
        iFeelBadAboutMyNeckSaved.getAuthors().add(noraSaved);
        theGirlWithTheDragonTatooSaved.getAuthors().add(stiegSaved);

        authorRepository.save(noraSaved);
        authorRepository.save(stiegSaved);

        Publisher bertelsmann = new Publisher();
        bertelsmann.setPublisherName("Bertelsmann");
        bertelsmann.setState("Germany");
        bertelsmann.setCity("Gütersloh");
        bertelsmann.setZip("33335");
        bertelsmann.setAddress("Carl-Bertelsmann-Straße 270");

        Publisher bertelsmannSaved = publisherRepository.save(bertelsmann);

        iFeelBadAboutMyNeckSaved.setPublisher(bertelsmannSaved);
        theGirlWithTheDragonTatooSaved.setPublisher(bertelsmannSaved);


        bookRepository.save(iFeelBadAboutMyNeckSaved);
        bookRepository.save(theGirlWithTheDragonTatooSaved);
        authorRepository.save(noraSaved);
        authorRepository.save(stiegSaved);

        System.out.println("in bootstrap!");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
