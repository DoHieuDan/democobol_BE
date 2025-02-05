package fa.training.service;

import fa.training.model.User;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

public interface DeleteUserService {
    public void deleteUserById(String userId) throws NoResourceFoundException;
    public List<User> findByUserId(String userId);
}
