package fa.training.dto.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    @NotEmpty(message = "First Name can NOT be empty...")
    String firstName;

    @NotEmpty(message = "Last Name can NOT be empty...")
    String lastName;

    @NotEmpty(message = "Password can NOT be empty...")
    @Size(min = 8, max = 8, message = "Password must be exactly 8 characters...")
    String password;

    //    @NotNull(message = "User Type can NOT be empty...")
//    char role;
    @NotNull(message = "User Type can NOT be empty...")
    @Pattern(regexp = "[AU]", message = "User type must be 'A' or 'U'")
    String role;
}
