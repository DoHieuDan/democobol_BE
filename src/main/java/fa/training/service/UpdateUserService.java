package fa.training.service;


import fa.training.dto.request.UserRequestDTO;
import fa.training.dto.request.UserUpdateRequest;
import fa.training.dto.response.UserResponseDTO;
import fa.training.mapper.UserMapper;
import fa.training.model.User;
import fa.training.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateUserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponseDTO updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("User ID NOT found..."));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponseDTO getUserById(String userId) {
        return userMapper.toUserResponse(userRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("User ID NOT found...")));
    }
}
