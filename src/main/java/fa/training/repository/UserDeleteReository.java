package fa.training.repository;

import fa.training.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDeleteReository extends JpaRepository<User, Long> {
    List<User> findByUserId(String userId);
}
