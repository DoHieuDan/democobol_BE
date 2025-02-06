package fa.training.controller;


import fa.training.dto.request.UserRequestDTO;
import fa.training.dto.response.ApiResponse;
import fa.training.dto.response.UserResponseDTO;
import fa.training.service.UpdateUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateUsetController {
    UpdateUserService updateUserService;

    @PutMapping("/{userId}")
    ApiResponse<UserResponseDTO> updateUser(@PathVariable String userId, @RequestBody UserRequestDTO request) {
        return ApiResponse.<UserResponseDTO>builder()
                .result(updateUserService.updateUser(userId, request))
                .build();
    }
}
