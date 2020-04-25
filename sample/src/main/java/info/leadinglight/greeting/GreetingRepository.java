package info.leadinglight.greeting;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
interface GreetingRepository extends CrudRepository<GreetingEntity, String> {
}
