package fa.training.service;

import fa.training.model.User;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Optional;

public interface DeleteUserService {
    public void deleteUserById(String userId) throws NoResourceFoundException;
    public Optional<User> findByUserId(String userId);
}
