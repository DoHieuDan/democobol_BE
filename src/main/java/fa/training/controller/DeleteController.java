package fa.training.controller;

import fa.training.dto.response.ApiResponse;
import fa.training.dto.response.UserResponseDTO;
import fa.training.service.DeleteUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Controller
@RequestMapping("/api/nhon")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteController {

    private DeleteUserService deleteUserService;


    @DeleteMapping("/{userId}")
    ApiResponse<String> deleteUser(@PathVariable String userId) throws NoResourceFoundException {
        deleteUserService.deleteUserById(userId);
        return ApiResponse.<String>builder().result("User has been deleted").build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable String userId) {
        UserResponseDTO userResponse = deleteUserService.findByUserId(userId);
        if (userResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userResponse);
    }

}
