package dev.pollito.post.mapper;

import dev.pollito.post.model.User;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  List<User> map(List<com.typicode.jsonplaceholder.model.User> users);
}
