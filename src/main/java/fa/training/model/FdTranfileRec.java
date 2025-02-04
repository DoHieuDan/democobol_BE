package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FdTranfileRec {

  private String fdTransId;
  private String fdAcctData;
   
  public  FdTranfileRec(){
      fdTransId = FieldFormat.format(16, ValueConst.SPACE);
      fdAcctData = FieldFormat.format(334, ValueConst.SPACE);
  }
}