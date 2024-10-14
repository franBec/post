package dev.pollito.post.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.typicode.jsonplaceholder.api.UserApi;
import com.typicode.jsonplaceholder.model.User;
import dev.pollito.post.mapper.UserMapper;
import dev.pollito.post.service.impl.UserServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
  @InjectMocks private UserServiceImpl userService;
  @Mock private UserApi userApi;
  @Spy private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @Test()
  void whenGetUsersThenReturnUserList() {
    when(userApi.getUsers()).thenReturn(List.of(new User()));

    assertFalse(userService.getUsers().isEmpty());
  }
}
