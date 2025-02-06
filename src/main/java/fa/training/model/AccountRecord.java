package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "accounts")
public class AccountRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long acctId;

    @Column(name = "active_status")
    private String acctActiveStatus;

    @Column(name = "curr_bal")
    private BigDecimal acctCurrBal;

    @Column(name = "credit_limit")
    private BigDecimal acctCreditLimit;

    @Column(name = "cash_credit_limit")
    private BigDecimal acctCashCreditLimit;

    @Column(name = "open_date")
    private String acctOpenDate;

    @Column(name = "expiration_date")
    private String acctExpiraionDate;

    @Column(name = "reissue_date")
    private String acctReissueDate;

    @Column(name = "curr_cyc_credit")
    private BigDecimal acctCurrCycCredit;

    @Column(name = "curr_cyc_debit")
    private BigDecimal acctCurrCycDebit;

    @Column(name = "addr_zip")
    private String acctAddrZip;

    @Column(name = "group_id")
    private String acctGroupId;

//    private String filler1;

    public AccountRecord() {
        acctId = 0;
        acctActiveStatus = ValueConst.SPACE;
        acctCurrBal = new BigDecimal(0);
        acctCreditLimit = new BigDecimal(0);
        acctCashCreditLimit = new BigDecimal(0);
        acctOpenDate = FieldFormat.format(10, ValueConst.SPACE);
        acctExpiraionDate = FieldFormat.format(10, ValueConst.SPACE);
        acctReissueDate = FieldFormat.format(10, ValueConst.SPACE);
        acctCurrCycCredit = new BigDecimal(0);
        acctCurrCycDebit = new BigDecimal(0);
        acctAddrZip = FieldFormat.format(10, ValueConst.SPACE);
        acctGroupId = FieldFormat.format(10, ValueConst.SPACE);
//        filler1 = FieldFormat.format(178, ValueConst.SPACE);
    }
}