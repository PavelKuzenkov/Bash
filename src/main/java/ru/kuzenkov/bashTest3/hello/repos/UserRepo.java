package ru.kuzenkov.bashTest3.hello.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kuzenkov.bashTest3.hello.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
