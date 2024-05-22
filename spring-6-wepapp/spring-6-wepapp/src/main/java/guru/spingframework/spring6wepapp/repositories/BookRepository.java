package guru.spingframework.spring6wepapp.repositories;

import guru.spingframework.spring6wepapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {
}
