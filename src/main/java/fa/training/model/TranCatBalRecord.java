package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class TranCatBalRecord {

  private long trancatAcctId;
  private String trancatTypeCd;
  private short trancatCd;
  private BigDecimal tranCatBal;
  private String filler1;
   
  public  TranCatBalRecord(){
      trancatAcctId = 0;
      trancatTypeCd = FieldFormat.format(2, ValueConst.SPACE);
      trancatCd = (short)0;
      tranCatBal = new BigDecimal(0);
      filler1 = FieldFormat.format(22, ValueConst.SPACE);
  }
}