package dev.pollito.post.service.impl;

import dev.pollito.post.mapper.UserMapper;
import dev.pollito.post.model.SortDirection;
import dev.pollito.post.model.User;
import dev.pollito.post.model.UserSortProperty;
import dev.pollito.post.model.Users;
import dev.pollito.post.repository.UserRepository;
import dev.pollito.post.service.UserService;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserMapper userMapper;
  private final UserRepository userRepository;

  @Override
  public Users getUsers(
      Integer pageNumber,
      Integer pageSize,
      @NotNull UserSortProperty sortProperty,
      @NotNull SortDirection sortDirection,
      String q) {
    return userMapper.map(
        userRepository.findAllByQuery(
            q,
            PageRequest.of(
                pageNumber,
                pageSize,
                Sort.Direction.fromString(sortDirection.getValue()),
                sortProperty.getValue())));
  }

  @Override
  public User getUser(Integer id) {
    return userMapper.map(
        userRepository.findById(Long.valueOf(id)).orElseThrow(NoSuchElementException::new));
  }
}
