package fa.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "dis_group")
public class DisGroup {
    @EmbeddedId
    private DisGroupId id;
    @Column(name = "dis_int_rate")
    private BigDecimal disIntRate;
}
