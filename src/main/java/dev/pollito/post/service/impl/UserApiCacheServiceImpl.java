package dev.pollito.post.service.impl;

import static dev.pollito.post.config.CacheConfig.JSON_PLACEHOLDER_CACHE;

import com.typicode.jsonplaceholder.api.UserApi;
import com.typicode.jsonplaceholder.model.User;
import dev.pollito.post.service.UserApiCacheService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApiCacheServiceImpl implements UserApiCacheService {
  private final UserApi userApi;

  @Override
  @Cacheable(value = JSON_PLACEHOLDER_CACHE)
  public List<User> getUsers() {
    return userApi.getUsers();
  }
}
