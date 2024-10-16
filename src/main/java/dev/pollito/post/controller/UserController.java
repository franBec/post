package dev.pollito.post.controller;

import dev.pollito.post.api.UsersApi;
import dev.pollito.post.model.SortDirection;
import dev.pollito.post.model.UserSortProperty;
import dev.pollito.post.model.Users;
import dev.pollito.post.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {
  private final UserService userService;

  @Override
  public ResponseEntity<Users> getUsers(
      Integer pageNumber,
      Integer pageSize,
      UserSortProperty sortProperty,
      SortDirection sortDirection,
      String q) {
    return ResponseEntity.ok(
        userService.getUsers(pageNumber, pageSize, sortProperty, sortDirection, q));
  }
}
