package info.leadinglight.micronaut.jobs.server.util;

public class NotImplementedException extends RuntimeException {
    public NotImplementedException() {
        super("not implemented");
    }

    public NotImplementedException(String message) {
        super(message);
    }

    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotImplementedException(Throwable cause) {
        super(cause);
    }
}
