package com.example.hortfruit.repository.user;

import com.example.hortfruit.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(name = "select * from usuario u where u.usuario = ?1")
    Optional<User> findUserByUsername(String username);
}
