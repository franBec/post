package dev.pollito.post.controller.advice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import dev.pollito.post.exception.JsonPlaceholderException;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ExtendWith(MockitoExtension.class)
class GlobalControllerAdviceTest {
  @InjectMocks private GlobalControllerAdvice globalControllerAdvice;

  @Contract(pure = true)
  private static @NotNull Stream<HttpStatus> httpStatusProvider() {
    return Stream.of(HttpStatus.BAD_REQUEST, HttpStatus.INTERNAL_SERVER_ERROR);
  }

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

  @ParameterizedTest
  @MethodSource("httpStatusProvider")
  void whenJsonPlaceholderExceptionThenReturnProblemDetail(@NotNull HttpStatus httpStatus) {
    JsonPlaceholderException e = mock(JsonPlaceholderException.class);
    when(e.getStatus()).thenReturn(httpStatus.value());

    ProblemDetail response = globalControllerAdvice.handle(e);
    problemDetailAssertions(response, httpStatus);
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
