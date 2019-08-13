package co.orolabs.SpringInitializr.SpringInitializr.bootStrap;

import co.orolabs.SpringInitializr.SpringInitializr.model.Author;
import co.orolabs.SpringInitializr.SpringInitializr.model.Book;
import co.orolabs.SpringInitializr.SpringInitializr.model.Publisher;
import co.orolabs.SpringInitializr.SpringInitializr.repositories.AuthorRepository;
import co.orolabs.SpringInitializr.SpringInitializr.repositories.BookRepository;
import co.orolabs.SpringInitializr.SpringInitializr.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("Addison-Wesley");
        publisher.setAddress("75 Arlington Street Suite 300 Boston MA 02116 USA");

        publisherRepository.save(publisher);


        //Eric
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod","Johnson");
        Book notEJB = new Book("J2EE wihtout EJB", "23444", publisher);
        rod.getBooks().add(notEJB);

        authorRepository.save(rod);
        bookRepository.save(notEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
