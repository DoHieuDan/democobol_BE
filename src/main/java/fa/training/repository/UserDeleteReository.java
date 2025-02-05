package fa.training.repository;

import fa.training.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDeleteReository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}
