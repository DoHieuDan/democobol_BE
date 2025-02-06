package fa.training.mapper;

import fa.training.dto.request.UserRequestDTO;
import fa.training.dto.request.UserUpdateRequest;
import fa.training.dto.response.UserResponseDTO;
import fa.training.lib.util.FieldFormat;
import fa.training.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserRequestDTO userRequestDTO) {
        return User.builder()
                .userId(userRequestDTO.getUserId())
                .firstName(userRequestDTO.getFirstName())
                .lastName(userRequestDTO.getLastName())
                .password(userRequestDTO.getPassword())
                .role(userRequestDTO.getRole())
                .build();
    }

    public UserResponseDTO toUserResponse(User user) {
        return UserResponseDTO.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    public void updateUser(User user, UserUpdateRequest request) {
        if (request != null) {
            user.setFirstName(FieldFormat.format(20, request.getFirstName()));
            user.setLastName(FieldFormat.format(20, request.getLastName()));
            user.setPassword(request.getPassword());
            user.setRole(request.getRole());
        }
    }

}
