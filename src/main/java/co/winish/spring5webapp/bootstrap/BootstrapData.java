package co.winish.spring5webapp.bootstrap;

import co.winish.spring5webapp.domain.Author;
import co.winish.spring5webapp.domain.Book;
import co.winish.spring5webapp.domain.Publisher;
import co.winish.spring5webapp.repositories.AuthorRepository;
import co.winish.spring5webapp.repositories.BookRepository;
import co.winish.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        Publisher james = new Publisher("James Hetfield", "Playboy mansion, 1");
        publisherRepository.save(james);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "234234");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of book: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
}
