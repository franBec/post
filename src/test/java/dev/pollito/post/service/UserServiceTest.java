package dev.pollito.post.service;

import static dev.pollito.post.MockData.USERS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import dev.pollito.post.mapper.UserMapper;
import dev.pollito.post.model.SortDirection;
import dev.pollito.post.model.UserSortProperty;
import dev.pollito.post.model.Users;
import dev.pollito.post.service.impl.UserApiCacheServiceImpl;
import dev.pollito.post.service.impl.UserServiceImpl;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
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
  @Mock private UserApiCacheServiceImpl userApi;

  @SuppressWarnings("unused")
  @Spy
  private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @BeforeEach
  void setUp() {
    when(userApi.getUsers()).thenReturn(USERS);
  }

  @Test()
  void whenGetUsersThenReturnUserList() {
    Users response = userService.getUsers(0, 10, UserSortProperty.ID, SortDirection.ASC, null);
    assertEquals(10, response.getTotal());
    assertEquals(0, response.getPageable().getPageNumber());
    assertEquals(10, response.getPageable().getPageSize());
    assertEquals(1, response.getContent().getFirst().getId());
    assertEquals(10, response.getContent().getLast().getId());
  }

  @Test()
  void whenGetUsersDescThenReturnUserListDesc() {
    Users response = userService.getUsers(0, 10, UserSortProperty.ID, SortDirection.DESC, null);
    assertEquals(10, response.getContent().getFirst().getId());
    assertEquals(1, response.getContent().getLast().getId());
  }

  @Test
  void whenGetUsersWithQThenReturnSubList() {
    Users lePage0 = userService.getUsers(0, 5, UserSortProperty.ID, SortDirection.ASC, "le");
    Users lePage1 = userService.getUsers(1, 5, UserSortProperty.ID, SortDirection.ASC, "le");
    Users biz = userService.getUsers(0, 10, UserSortProperty.ID, SortDirection.ASC, "biz");
    assertEquals(5, lePage0.getContent().size());
    assertEquals(2, lePage1.getContent().size());
    assertEquals(3, biz.getTotal());
  }

  @Test
  void whenSortByPropertyThenReturnSortedList() {
    Users sortByEmail =
        userService.getUsers(0, 10, UserSortProperty.EMAIL, SortDirection.ASC, null);
    Users sortByName = userService.getUsers(0, 10, UserSortProperty.NAME, SortDirection.ASC, null);
    Users sortByUsername =
        userService.getUsers(0, 10, UserSortProperty.USERNAME, SortDirection.ASC, null);

    assertEquals("Chaim_McDermott@dana.io", sortByEmail.getContent().getFirst().getEmail());
    assertEquals("Telly.Hoeger@billy.biz", sortByEmail.getContent().getLast().getEmail());

    assertEquals("Chelsey Dietrich", sortByName.getContent().getFirst().getName());
    assertEquals("Patricia Lebsack", sortByName.getContent().getLast().getName());

    assertEquals("Antonette", sortByUsername.getContent().getFirst().getUsername());
    assertEquals("Samantha", sortByUsername.getContent().getLast().getUsername());
  }

  @Test
  void whenGetUserThenReturnUser() {
    assertNotNull(userService.getUser(1));
  }

  @Test
  void whenGetUserThatDoesntExistThenThrowException() {
    assertThrows(NoSuchElementException.class, () -> userService.getUser(-1));
  }
}
