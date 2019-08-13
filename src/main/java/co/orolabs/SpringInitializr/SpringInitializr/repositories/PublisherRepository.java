package co.orolabs.SpringInitializr.SpringInitializr.repositories;

import co.orolabs.SpringInitializr.SpringInitializr.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
