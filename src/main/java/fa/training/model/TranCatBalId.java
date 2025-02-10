package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class TranCatBalId implements Serializable {
    @Column(name = "acct_id")
    private int tranCatAccId;
    @Column(name = "type_cd")
    private String tranCatTypeCd;
    @Column(name = "cd")
    private short tranCatCd;

    public TranCatBalId( ){
        tranCatAccId = 0;
        tranCatTypeCd = FieldFormat.format(2, ValueConst.SPACE);
        tranCatCd = (short)0;
    }
}

