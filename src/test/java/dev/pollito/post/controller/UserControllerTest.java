package dev.pollito.post.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import dev.pollito.post.model.SortDirection;
import dev.pollito.post.model.UserSortProperty;
import dev.pollito.post.model.Users;
import dev.pollito.post.service.UserService;
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
    when(userService.getUsers(
            any(Integer.class),
            any(Integer.class),
            any(UserSortProperty.class),
            any(SortDirection.class),
            anyString()))
        .thenReturn(new Users());

    ResponseEntity<Users> response =
        userController.getUsers(0, 10, UserSortProperty.ID, SortDirection.ASC, "q");
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
  }
}
