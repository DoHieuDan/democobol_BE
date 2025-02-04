package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import java.math.BigDecimal;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

public class AccountRecord {  

  @Getter
  @Setter
  private long acctId;
  @Getter
  @Setter
  private String acctActiveStatus;
  @Getter
  @Setter
  private BigDecimal acctCurrBal;
  @Getter
  @Setter
  private BigDecimal acctCreditLimit;
  @Getter
  @Setter
  private BigDecimal acctCashCreditLimit;
  @Getter
  @Setter
  private String acctOpenDate;
  @Getter
  @Setter
  private String acctExpiraionDate;
  @Getter
  @Setter
  private String acctReissueDate;
  @Getter
  @Setter
  private BigDecimal acctCurrCycCredit;
  @Getter
  @Setter
  private BigDecimal acctCurrCycDebit;
  @Getter
  @Setter
  private String acctAddrZip;
  @Getter
  @Setter
  private String acctGroupId;
  @Getter
  @Setter
  private String filler1;
   
  public  AccountRecord(){
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
      filler1 = FieldFormat.format(178, ValueConst.SPACE);
  }
}