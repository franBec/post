package dev.pollito.post.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.typicode.jsonplaceholder.api.UserApi;
import com.typicode.jsonplaceholder.model.ApiResponse;
import com.typicode.jsonplaceholder.model.User;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class UserApiImplTest {
  @InjectMocks private UserApiImpl userApi;
  @Mock private UserApi delegate;

  @Test
  void whenDelegateIsCalledThenExpectedBehaviour() {
    when(delegate.getUsers()).thenReturn(List.of(new User()));
    when(delegate.getUsersWithHttpInfo())
        .thenReturn(new ApiResponse<>(HttpStatus.OK.value(), Map.of(), List.of(new User())));
    assertFalse(userApi.getUsers().isEmpty());
    assertFalse(userApi.getUsersWithHttpInfo().getData().isEmpty());
  }
}
