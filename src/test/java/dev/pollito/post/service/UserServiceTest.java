package dev.pollito.post.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import dev.pollito.post.entity.User;
import dev.pollito.post.mapper.UserMapper;
import dev.pollito.post.model.SortDirection;
import dev.pollito.post.model.UserSortProperty;
import dev.pollito.post.repository.UserRepository;
import dev.pollito.post.service.impl.UserServiceImpl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
  @InjectMocks private UserServiceImpl userService;
  @Mock private UserRepository userRepository;

  @SuppressWarnings("unused")
  @Spy
  private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @Test
  void whenGetUsersThenReturnusers() {
    when(userRepository.findAll(any(Pageable.class)))
        .thenReturn(new PageImpl<>(List.of(), PageRequest.of(0, 10), 0));
    assertNotNull(userService.getUsers(0, 10, UserSortProperty.ID, SortDirection.ASC, null));
  }

  @Test
  void whenGetUserThenReturnUser() {
    when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(new User()));
    assertNotNull(userService.getUser(1));
  }

  @Test
  void whenUserNotFoundThenThrowNoSuchElementException() {
    when(userRepository.findById(any(Long.class))).thenReturn(Optional.empty());
    assertThrows(NoSuchElementException.class, () -> userService.getUser(-1));
  }
}
