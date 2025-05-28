package com.server.exception;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  private ResponseEntity<Object> buildResponseEntity(
      HttpStatus status, String message, HttpServletRequest request) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("status", status.value());
    body.put("error", status.getReasonPhrase());
    body.put("message", message);
    body.put("path", request.getRequestURI());
    return new ResponseEntity<>(body, status);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(
      ResourceNotFoundException ex, HttpServletRequest request) {
    return buildResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage(), request);
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<Object> handleBadRequest(
      BadRequestException ex, HttpServletRequest request) {
    return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
  }

  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<Object> handleUnauthorized(
      UnauthorizedException ex, HttpServletRequest request) {
    return buildResponseEntity(HttpStatus.UNAUTHORIZED, ex.getMessage(), request);
  }

  @ExceptionHandler(ForbiddenException.class)
  public ResponseEntity<Object> handleForbidden(ForbiddenException ex, HttpServletRequest request) {
    return buildResponseEntity(HttpStatus.FORBIDDEN, ex.getMessage(), request);
  }

  @ExceptionHandler(ConflictException.class)
  public ResponseEntity<Object> handleConflict(ConflictException ex, HttpServletRequest request) {
    return buildResponseEntity(HttpStatus.CONFLICT, ex.getMessage(), request);
  }

  @ExceptionHandler(ApplicationException.class)
  public ResponseEntity<Object> handleAppException(
      ApplicationException ex, HttpServletRequest request) {
    return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleOtherExceptions(Exception ex, HttpServletRequest request) {
    return buildResponseEntity(
        HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error occurred", request);
  }
}
