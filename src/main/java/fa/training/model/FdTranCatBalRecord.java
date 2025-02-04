package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FdTranCatBalRecord {

  private long fdTrancatAcctId;
  private String fdTrancatTypeCd;
  private short fdTrancatCd;
  private String fdFdTranCatData;
   
  public  FdTranCatBalRecord(){
      fdTrancatAcctId = 0;
      fdTrancatTypeCd = FieldFormat.format(2, ValueConst.SPACE);
      fdTrancatCd = (short)0;
      fdFdTranCatData = FieldFormat.format(33, ValueConst.SPACE);
  }
}