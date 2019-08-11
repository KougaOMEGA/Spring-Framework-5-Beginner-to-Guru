package co.orolabs.SpringInitializr.SpringInitializr.repositories;

import co.orolabs.SpringInitializr.SpringInitializr.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
