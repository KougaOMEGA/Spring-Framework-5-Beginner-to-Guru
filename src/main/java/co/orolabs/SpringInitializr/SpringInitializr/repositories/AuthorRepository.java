package co.orolabs.SpringInitializr.SpringInitializr.repositories;

import co.orolabs.SpringInitializr.SpringInitializr.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
