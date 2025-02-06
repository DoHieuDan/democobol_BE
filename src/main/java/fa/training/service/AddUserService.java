package fa.training.service;

import fa.training.dto.request.UserRequestDTO;
import fa.training.dto.response.UserResponseDTO;
import fa.training.lib.util.FieldFormat;
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
public class AddUserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        if(userRepository.existsByUserId(userRequestDTO.getUserId()))
            throw new RuntimeException("User ID already exist...");

        User user = userMapper.toUser(userRequestDTO);

        user.setFirstName(FieldFormat.format(20, user.getFirstName()));
        user.setLastName(FieldFormat.format(20, user.getLastName()));

        return userMapper.toUserResponse(userRepository.save(user));
    }
}
