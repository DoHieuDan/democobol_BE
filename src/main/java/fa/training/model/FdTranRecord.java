package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FdTranRecord {

  private String fdTranId;
  private String fdCustData;
   
  public  FdTranRecord(){
      fdTranId = FieldFormat.format(16, ValueConst.SPACE);
      fdCustData = FieldFormat.format(334, ValueConst.SPACE);
  }
}