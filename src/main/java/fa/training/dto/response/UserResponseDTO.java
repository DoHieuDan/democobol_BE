package fa.training.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    String firstName;
    String lastName;
    String userId;
    String password;
    boolean isBlock;
    char role;
}
