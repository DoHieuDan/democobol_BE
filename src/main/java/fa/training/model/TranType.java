package fa.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tran_type")
public class TranType {
    @Id
    private String tranType;

    @Column(name = "type_desc")
    private String tranTypeDes;
}
