package fa.training.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
    private long acctId;
    private String acctActiveStatus;
    private BigDecimal acctCurrBal;
    private BigDecimal acctCreditLimit;
    private BigDecimal acctCashCreditLimit;
    private String acctOpenDate;
    private String acctExpiraionDate;
    private String acctReissueDate;
    private BigDecimal acctCurrCycCredit;
    private BigDecimal acctCurrCycDebit;
    private String acctAddrZip;
    private String acctGroupId;
}
