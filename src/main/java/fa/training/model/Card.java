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
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "card_number", unique = true)
    private String cardNum;

    @Column(name = "account_id", unique = true)
    private Long acctId;

    @Column(name = "card_cvv")
    private int cardCvvCd;

    @Column(name = "embossed_name")
    private String embossedName;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "expiry_date")
    private Date expiryDate;
}
