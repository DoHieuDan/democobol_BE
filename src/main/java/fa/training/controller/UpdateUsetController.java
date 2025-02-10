package fa.training.controller;


import fa.training.dto.request.UserRequestDTO;
import fa.training.dto.request.UserUpdateRequest;
import fa.training.dto.response.ApiResponse;
import fa.training.dto.response.UserResponseDTO;
import fa.training.service.UpdateUserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateUsetController {
    UpdateUserService updateUserService;

    @PutMapping("/{userId}")
    ApiResponse<UserResponseDTO> updateUser(@PathVariable String userId,@Valid @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponseDTO>builder()
                .result(updateUserService.updateUser(userId, request))
                .message("User " + userId + " has been updated ...")
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponseDTO> getUserById(@PathVariable String userId){
        return ApiResponse.<UserResponseDTO>builder()
                .result(updateUserService.getUserById(userId))
                .build();
    }
    @GetMapping
    ApiResponse<List<UserResponseDTO>>getUserList(){
        return ApiResponse.<List<UserResponseDTO>>builder()
                .code(200)
                .result(updateUserService.getUserList())
                .message("")
                .build();
    }
}
