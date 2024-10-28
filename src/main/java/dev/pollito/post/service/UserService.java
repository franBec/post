package dev.pollito.post.service;

import dev.pollito.post.model.SortDirection;
import dev.pollito.post.model.User;
import dev.pollito.post.model.UserSortProperty;
import dev.pollito.post.model.Users;
import org.jetbrains.annotations.NotNull;

public interface UserService {
  Users getUsers(
      Integer pageNumber,
      Integer pageSize,
      @NotNull UserSortProperty sortProperty,
      @NotNull SortDirection sortDirection,
      String q);

  User getUser(Integer id);
}
