package fa.training.controller;

import fa.training.dto.request.UserRequestDTO;
import fa.training.dto.response.ApiResponse;
import fa.training.dto.response.UserResponseDTO;
import fa.training.service.AddUserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddUserController {
    AddUserService userAddService;

    @PostMapping
    public ApiResponse<UserResponseDTO> addUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return ApiResponse.<UserResponseDTO>builder()
                .result(userAddService.addUser(userRequestDTO))
                .build();
    }
}
