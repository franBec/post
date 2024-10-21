package dev.pollito.post.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.typicode.jsonplaceholder.api.UserApi;
import com.typicode.jsonplaceholder.model.User;
import dev.pollito.post.service.impl.UserApiCacheServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserApiCacheServiceTest {
  @InjectMocks private UserApiCacheServiceImpl userApiCacheService;
  @Mock private UserApi userApi;

  @Test
  void whenDelegateIsCalledThenExpectedBehaviour() {
    when(userApi.getUsers()).thenReturn(List.of(new User()));
    assertFalse(userApiCacheService.getUsers().isEmpty());
  }
}
