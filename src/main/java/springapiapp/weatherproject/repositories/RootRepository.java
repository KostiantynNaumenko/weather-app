package springapiapp.weatherproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springapiapp.weatherproject.model.ConvertedRoot;

@Repository
public interface RootRepository extends CrudRepository<ConvertedRoot, Long> {
}
