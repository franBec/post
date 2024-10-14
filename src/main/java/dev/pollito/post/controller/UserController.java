package dev.pollito.post.controller;

import dev.pollito.post.api.UsersApi;
import dev.pollito.post.model.User;
import dev.pollito.post.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {
  private final UserService userService;

  @Override
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok(userService.getUsers());
  }
}
