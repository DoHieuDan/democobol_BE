package fa.training.model;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class DisGroupId implements Serializable {
   @Column(name = "dis_acct_group_id")
   private String disAccGroupId;
   @Column(name = "dis_tran_type_cd")
   private String disTranTypeCd;
   @Column(name = "dis_tran_cat_cd")
   private int disTranCatCode;
}
