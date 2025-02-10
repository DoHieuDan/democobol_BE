package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "card_xref")
public class CardXrefRecord {

    @Id
    @Column(name = "num")
    private String xrefCardNum;

    @Column(name = "cust_id")
    private long xrefCustId;

    @Column(name = "acct_id")
    private long xrefAcctId;
//    private String filler1;

    public CardXrefRecord() {
        xrefCardNum = FieldFormat.format(16, ValueConst.SPACE);
        xrefCustId = 0;
        xrefAcctId = 0;
//        filler1 = FieldFormat.format(14, ValueConst.SPACE);
    }
}