package guru.spingframework.spring6wepapp.repositories;

import guru.spingframework.spring6wepapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
