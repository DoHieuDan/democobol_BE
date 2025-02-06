package fa.training.service;

import fa.training.dto.response.UserResponseDTO;
import fa.training.model.User;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

public interface DeleteUserService {
    public void deleteUserById(String userId) throws NoResourceFoundException;
    public UserResponseDTO findByUserId(String userId);
}
