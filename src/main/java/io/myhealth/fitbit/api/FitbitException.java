package io.myhealth.fitbit.api;

public class FitbitException extends RuntimeException {

    public FitbitException() {
        super();
    }

    public FitbitException(String message) {
        super(message);
    }

    public FitbitException(String message, Throwable cause) {
        super(message, cause);
    }
}
