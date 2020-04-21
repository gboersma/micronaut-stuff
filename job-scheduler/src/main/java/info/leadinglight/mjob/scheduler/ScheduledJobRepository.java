package info.leadinglight.mjob.scheduler;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ScheduledJobRepository extends CrudRepository<ScheduledJob, String> {
}
