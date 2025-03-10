package fa.training.controller;

import fa.training.dto.request.UserRequestDTO;
import fa.training.dto.request.UserUpdateRequest;
import fa.training.dto.response.ApiResponse;
import fa.training.dto.response.UserPageResponseDTO;
import fa.training.dto.response.UserResponseDTO;
import fa.training.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    public ApiResponse<UserResponseDTO> addUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return ApiResponse.<UserResponseDTO>builder()
                .message("User " + userRequestDTO.getUserId() + " has been added...")
                .result(userService.addUser(userRequestDTO))
                .build();
    }

    @PostMapping("/user-sec-file")
    public ApiResponse<UserResponseDTO> addUserSecFile(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return ApiResponse.<UserResponseDTO>builder()
                .message("User " + userRequestDTO.getUserId() + " has been added...")
                .result(userService.addUserSecFile(userRequestDTO))
                .build();
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponseDTO> updateUser(@PathVariable String userId,@Valid @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponseDTO>builder()
                .result(userService.updateUser(userId, request))
                .message("User " + userId + " has been updated ...")
                .build();
    }
    @PutMapping("/user-sec-file/{userId}")
    ApiResponse<UserResponseDTO> updateUserSecFile(@PathVariable String userId,@Valid @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponseDTO>builder()
                .result(userService.updateUserSecFile(userId,request))
                .message("User " + userId + " has been updated ...")
                .code(200)
                .build();
    }
    @GetMapping
    ApiResponse<List<UserResponseDTO>>getUserList(){
        return ApiResponse.<List<UserResponseDTO>>builder()
                .code(200)
                .result(userService.getUserList())
                .message("")
                .build();
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable String userId) {
        ApiResponse<Void> response = userService.deleteUserById(userId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getUserById(@PathVariable String userId) {
        ApiResponse<UserResponseDTO> response = userService.findByUserId(userId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @GetMapping("/{size}/{page}")
    public ResponseEntity<UserPageResponseDTO> findAllUserPage(
            @PathVariable("size") Integer size,
            @PathVariable("page") Integer page) {
        return ResponseEntity.ok(userService.Paging(size, page));
    }
}
