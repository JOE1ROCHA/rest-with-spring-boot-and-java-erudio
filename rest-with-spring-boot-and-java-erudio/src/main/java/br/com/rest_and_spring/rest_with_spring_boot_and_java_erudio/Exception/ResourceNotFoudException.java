package br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoudException extends RuntimeException {
    public ResourceNotFoudException(String message) {
        super(message);
    }
}
