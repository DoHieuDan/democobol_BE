package fa.training.model;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class TranCatId implements Serializable {
    @Column(name = "type_cd")
    private String tranTypeCd;
    @Column(name = "cat_cd")
    private int tranCatCd;
}
