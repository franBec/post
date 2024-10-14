package dev.pollito.post.service.impl;

import static dev.pollito.post.config.CacheConfig.JSON_PLACEHOLDER_CACHE;

import com.typicode.jsonplaceholder.api.UserApi;
import dev.pollito.post.mapper.UserMapper;
import dev.pollito.post.model.User;
import dev.pollito.post.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserApi userApi;
  private final UserMapper userMapper;

  @Override
  @Cacheable(value = JSON_PLACEHOLDER_CACHE)
  public List<User> getUsers() {
    return userMapper.map(userApi.getUsers());
  }
}
