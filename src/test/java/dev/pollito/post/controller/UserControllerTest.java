package dev.pollito.post.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import dev.pollito.post.model.User;
import dev.pollito.post.service.UserService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
  @InjectMocks private UserController userController;
  @Mock private UserService userService;

  @Test
  void whenGetUsersThenReturn200() {
    when(userService.getUsers()).thenReturn(List.of(new User()));

    ResponseEntity<List<User>> response = userController.getUsers();
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertFalse(response.getBody().isEmpty());
  }
}
