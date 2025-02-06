package fa.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tran_cat")
public class TranCatRecord {
    @EmbeddedId
    private TranCatId id;
    @Column(name = "type_desc")
    private String tranCatTypeDes;
}
