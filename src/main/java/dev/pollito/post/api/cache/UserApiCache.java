package dev.pollito.post.api.cache;

import static dev.pollito.post.config.CacheConfig.JSON_PLACEHOLDER_CACHE;

import com.typicode.jsonplaceholder.api.UserApi;
import com.typicode.jsonplaceholder.model.ApiResponse;
import com.typicode.jsonplaceholder.model.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApiCache implements UserApi {
  private final UserApi delegate;

  @Override
  @Cacheable(value = JSON_PLACEHOLDER_CACHE)
  public List<User> getUsers() {
    return delegate.getUsers();
  }

  @Override
  public ApiResponse<List<User>> getUsersWithHttpInfo() {
    return delegate.getUsersWithHttpInfo();
  }
}
