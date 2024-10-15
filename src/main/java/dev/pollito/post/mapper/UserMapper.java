package dev.pollito.post.mapper;

import dev.pollito.post.model.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
  List<User> map(List<com.typicode.jsonplaceholder.model.User> users);
}
