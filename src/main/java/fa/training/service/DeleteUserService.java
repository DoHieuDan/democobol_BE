package fa.training.service;

import fa.training.dto.response.ApiResponse;
import fa.training.dto.response.UserResponseDTO;
import fa.training.mapper.UserMapper;
import fa.training.model.User;
import fa.training.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteUserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public ApiResponse<Void> deleteUserById(String userId) {
        User user = userRepository.findUserByUserId(userId);
        if (user == null) {
            return new ApiResponse<>(404, "User not found", null);
        }
        user.setBlock(true);
        userRepository.save(user);
        return new ApiResponse<>(200, "User successfully blocked", null);
    }

    public ApiResponse<UserResponseDTO> findByUserId(String userId) {
        User user = userRepository.findUserByUserId(userId);
        if (user == null) {
            return new ApiResponse<>(404, "User not found", null);
        }
        UserResponseDTO userResponseDTO = userMapper.toUserResponse(user);
        return new ApiResponse<>(200, "User found", userResponseDTO);
    }
}
