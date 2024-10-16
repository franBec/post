package dev.pollito.post.service;

import dev.pollito.post.model.SortDirection;
import dev.pollito.post.model.UserSortProperty;
import dev.pollito.post.model.Users;

public interface UserService {
  Users getUsers(
      Integer pageNumber,
      Integer pageSize,
      UserSortProperty sortProperty,
      SortDirection sortDirection,
      String q);
}
