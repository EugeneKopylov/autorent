package it.academy.service.validation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationException extends RuntimeException {

    private Map<String, String> errors = new HashMap<>();
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public ValidationException() {
    }

    public ValidationException(String fieldName, String errorMessage) {
        this.put(fieldName, errorMessage);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ValidationException setStatus(HttpStatus status) {
        this.status = status;

        return this;
    }

    public Map<String, String> get() {
        return this.errors;
    }

    public void put(String fieldName, String errorMessage) {
        this.errors.put(fieldName, errorMessage);
    }

    public void throwExceptionIfIsNotEmpty() {
        if(!this.errors.isEmpty()) {
            throw this;
        }
    }
}
