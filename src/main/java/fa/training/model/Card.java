package fa.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cards")
public class Card {
    @Id
    @Column(name = "num", unique = true)
    private String cardNum;

    @Column(name = "acct_id")
    private Long acctId;

    @Column(name = "ccv_cd")
    private int cardCvvCd;

    @Column(name = "embossed_name")
    private String embossedName;

    @Column(name = "active_status")
    private String isActive;

    @Column(name = "expiration_date")
    private String expiryDate;
}
