package info.leadinglight.mjob.scheduler;

public class JobException extends RuntimeException {
    public JobException() {
        super();
    }

    public JobException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobException(String message) {
        super(message);
    }

    public JobException(Throwable cause) {
        super(cause);
    }
}
