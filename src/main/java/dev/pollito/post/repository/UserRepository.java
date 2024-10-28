package dev.pollito.post.repository;

import dev.pollito.post.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
