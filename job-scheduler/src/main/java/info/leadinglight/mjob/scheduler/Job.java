package info.leadinglight.mjob.scheduler;

public interface Job {
    void execute(JobArguments args);
}
