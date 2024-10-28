package dev.pollito.post.mapper;

import dev.pollito.post.model.User;
import dev.pollito.post.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
  User map(dev.pollito.post.entity.User user);

  Users map(Page<dev.pollito.post.entity.User> userPage);
}
