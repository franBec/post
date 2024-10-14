package dev.pollito.post.controller.advice;

import dev.pollito.post.exception.JsonPlaceholderException;
import io.opentelemetry.api.trace.Span;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

  @ExceptionHandler(NoResourceFoundException.class)
  public ProblemDetail handle(@NotNull NoResourceFoundException e) {
    return buildProblemDetail(e, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(JsonPlaceholderException.class)
  public ProblemDetail handle(@NotNull JsonPlaceholderException e) {
    return buildProblemDetail(
        e, e.getStatus() == 400 ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  public ProblemDetail handle(@NotNull Exception e) {
    return buildProblemDetail(e, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @NotNull
  private ProblemDetail buildProblemDetail(@NotNull Exception e, HttpStatus status) {
    log.error(e.getClass().getSimpleName() + " being handled", e);
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, e.getLocalizedMessage());
    problemDetail.setProperty("timestamp", DateTimeFormatter.ISO_INSTANT.format(Instant.now()));
    problemDetail.setProperty("trace", Span.current().getSpanContext().getTraceId());
    return problemDetail;
  }
}
