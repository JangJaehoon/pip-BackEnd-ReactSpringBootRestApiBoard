package restapi.prac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restapi.prac.entity.User;
import restapi.prac.model.UserRequestDTO;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
