package fa.training.service.Impl;

import fa.training.dto.response.UserResponseDTO;
import fa.training.mapper.UserMapper;
import fa.training.model.User;
import fa.training.repository.UserDeleteReository;
import fa.training.service.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Optional;


@Service
public class DeleteUserServiceImpl implements DeleteUserService {
    @Autowired
    UserDeleteReository userRepository;
    UserMapper userMapper;

    @Override
    public void deleteUserById(String userId) {
        User user = userRepository.findByUserId(userId);
        user.setBlock(true);
        userRepository.save(user);
    }

    @Override
    public UserResponseDTO findByUserId(String userId) {
        User user = userRepository.findByUserId(userId);
        return userMapper.toUserResponse(user);
    }
}
