package dev.pollito.post.controller;

import dev.pollito.post.api.UserApi;
import dev.pollito.post.model.User;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {
  @Override
  public ResponseEntity<List<User>> getUsers() {
    return UserApi.super.getUsers();
  }
}
