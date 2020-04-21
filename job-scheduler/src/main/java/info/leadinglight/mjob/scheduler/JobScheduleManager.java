package info.leadinglight.mjob.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class JobScheduleManager {
    public ScheduledJob create(ScheduledJob scheduledJob) {
        beforePersist(scheduledJob);
        return scheduledJobRepository.save(scheduledJob);
    }

    public ScheduledJob get(String id) {
        ScheduledJob scheduledJob = scheduledJobRepository.findById(id).get();
        afterRetrieve(scheduledJob);
        return scheduledJob;
    }

    public List<ScheduledJob> getAll() {
        List<ScheduledJob> scheduledJobs = new ArrayList<>();
        for (ScheduledJob job: scheduledJobRepository.findAll()) {
            afterRetrieve(job);
            scheduledJobs.add(job);
        }
        return scheduledJobs;
    }

    private void beforePersist(ScheduledJob scheduledJob) {
        if (scheduledJob != null) {
            JobArguments args = scheduledJob.getArgs();
            String json = getJsonFromArgs(args);
            scheduledJob.setArgsJson(json);
        }
    }

    private void afterRetrieve(ScheduledJob scheduledJob) {
        if (scheduledJob != null) {
            String json = scheduledJob.getArgsJson();
            JobArguments args = getArgsFromJson(json);
            scheduledJob.setArgs(args);
        }
    }

    private JobArguments getArgsFromJson(String json) {
        if (json != null && json.length() > 0) {
            try {
                JobArguments args = objectMapper.readValue(json, JobArguments.class);
                return args;
            } catch(JsonProcessingException e) {
                throw new JobException("cannot get args from json: " + json, e);
            }
        } else {
            return new JobArguments();
        }
    }

    private String getJsonFromArgs(JobArguments args) {
        if (args != null) {
            try {
                String json = objectMapper.writeValueAsString(args);
                return json;
            } catch(JsonProcessingException e) {
                throw new JobException("cannot get json for args: " + args, e);
            }
        } else {
            return null;
        }
    }

    @Inject
    private ScheduledJobRepository scheduledJobRepository;

    @Inject
    private ObjectMapper objectMapper;
}
