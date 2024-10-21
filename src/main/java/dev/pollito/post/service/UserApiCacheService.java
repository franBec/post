package dev.pollito.post.service;

import com.typicode.jsonplaceholder.model.User;
import java.util.List;

public interface UserApiCacheService {
  List<User> getUsers();
}
