package co.orolabs.SpringInitializr.SpringInitializr.bootStrap;

import co.orolabs.SpringInitializr.SpringInitializr.model.Author;
import co.orolabs.SpringInitializr.SpringInitializr.model.Book;
import co.orolabs.SpringInitializr.SpringInitializr.repositories.AuthorRepository;
import co.orolabs.SpringInitializr.SpringInitializr.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    private void initData(){
        //Eric
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","1234","Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod","Johnson");
        Book notEJB = new Book("J2EE wihtout EJB", "23444","Worx");
        rod.getBooks().add(notEJB);

        authorRepository.save(rod);
        bookRepository.save(notEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
