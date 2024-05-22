package guru.spingframework.spring6wepapp.repositories;

import guru.spingframework.spring6wepapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository <Publisher, Long>{
}
