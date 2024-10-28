package dev.pollito.post.controller.advice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ExtendWith(MockitoExtension.class)
class GlobalControllerAdviceTest {
  @InjectMocks private GlobalControllerAdvice globalControllerAdvice;

  private static void problemDetailAssertions(
      @NotNull ProblemDetail response, @NotNull HttpStatus httpStatus) {
    assertEquals(httpStatus.value(), response.getStatus());
    assertNotNull(response.getProperties());
    assertNotNull(response.getProperties().get("timestamp"));
    assertNotNull(response.getProperties().get("trace"));
  }

  @Test
  void whenNoResourceFoundExceptionThenReturnProblemDetail() {
    ProblemDetail response = globalControllerAdvice.handle(mock(NoResourceFoundException.class));
    problemDetailAssertions(response, HttpStatus.NOT_FOUND);
  }

  @Test
  void whenNoSuchElementExceptionThenReturnProblemDetail() {
    ProblemDetail response = globalControllerAdvice.handle(mock(NoSuchElementException.class));
    problemDetailAssertions(response, HttpStatus.NOT_FOUND);
  }

  @Test
  void whenExceptionThenReturnProblemDetail() {
    ProblemDetail response = globalControllerAdvice.handle(mock(Exception.class));
    problemDetailAssertions(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
