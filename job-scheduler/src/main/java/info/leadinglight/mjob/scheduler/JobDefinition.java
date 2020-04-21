package info.leadinglight.mjob.scheduler;

public interface JobDefinition {
    String getName();
    void execute(JobArguments args);
}
