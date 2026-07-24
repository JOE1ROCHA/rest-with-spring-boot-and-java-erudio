package br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.Exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String datails) {

}
