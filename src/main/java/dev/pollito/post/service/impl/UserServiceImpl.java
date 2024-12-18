package dev.pollito.post.service.impl;

import dev.pollito.post.mapper.UserMapper;
import dev.pollito.post.model.Pageable;
import dev.pollito.post.model.SortDirection;
import dev.pollito.post.model.User;
import dev.pollito.post.model.UserSortProperty;
import dev.pollito.post.model.Users;
import dev.pollito.post.service.UserService;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserApiCacheServiceImpl userApi;
  private final UserMapper userMapper;

  @Override
  public Users getUsers(
      Integer pageNumber,
      Integer pageSize,
      UserSortProperty sortProperty,
      SortDirection sortDirection,
      String q) {
    List<User> users = getUsersFromApi();
    users = filterUsers(q, users);
    users = sortUsers(users, sortProperty, sortDirection);

    return new Users()
        .content(usersSubList(users, pageNumber, pageSize))
        .pageable(new Pageable().pageNumber(pageNumber).pageSize(pageSize))
        .total(users.size());
  }

  @Override
  public User getUser(Integer id) {
    return getUsersFromApi().stream()
        .filter(user -> user.getId().equals(id))
        .findFirst()
        .orElseThrow(NoSuchElementException::new);
  }

  private List<User> getUsersFromApi() {
    return userMapper.map(userApi.getUsers());
  }

  private static List<User> filterUsers(String q, List<User> users) {
    if (Objects.nonNull(q) && !q.isEmpty()) {
      users = users.stream().filter(user -> filterUsersPredicate(q, user)).toList();
    }
    return users;
  }

  private static boolean filterUsersPredicate(@NotNull String q, @NotNull User user) {
    String query = q.toLowerCase();
    return (Objects.nonNull(user.getEmail()) && user.getEmail().toLowerCase().contains(query))
        || (Objects.nonNull(user.getName()) && user.getName().toLowerCase().contains(query))
        || (Objects.nonNull(user.getUsername())
            && user.getUsername().toLowerCase().contains(query));
  }

  private static List<User> sortUsers(
      List<User> users, @NotNull UserSortProperty sortProperty, SortDirection sortDirection) {
    Comparator<User> comparator =
        switch (sortProperty) {
          case EMAIL -> Comparator.comparing(User::getEmail);
          case ID -> Comparator.comparing(User::getId);
          case NAME -> Comparator.comparing(User::getName);
          case USERNAME -> Comparator.comparing(User::getUsername);
        };

    if (SortDirection.DESC.equals(sortDirection)) {
      comparator = comparator.reversed();
    }

    return users.stream().sorted(comparator).toList();
  }

  private static @NotNull List<User> usersSubList(
      @NotNull List<User> users, Integer pageNumber, Integer pageSize) {
    int total = users.size();
    int fromIndex = Math.min(pageNumber * pageSize, total);
    int toIndex = Math.min(fromIndex + pageSize, total);

    return users.subList(fromIndex, toIndex);
  }
}
