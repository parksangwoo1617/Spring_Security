package io.getarrays.userservice.domain.repo;

import io.getarrays.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
