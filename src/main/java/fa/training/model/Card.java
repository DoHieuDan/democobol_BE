package fa.training.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cards")
public class Card {
    private Long cardId;

    private Long acctId;

    private boolean isActive;

    private Long userId;

    private Date expiryDate;
}
