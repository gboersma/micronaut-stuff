package info.leadinglight.micronaut.jobs.server.job;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface JobRepository extends CrudRepository<Job, String> {
}
