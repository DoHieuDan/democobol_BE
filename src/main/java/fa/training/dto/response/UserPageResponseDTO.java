package fa.training.dto.response;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPageResponseDTO {
    private List<UserResponseDTO> users;
    private long totalUsers;
    private int totalPages;
}

