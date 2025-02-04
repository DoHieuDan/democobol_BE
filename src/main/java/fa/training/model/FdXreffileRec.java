package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FdXreffileRec {

  private String fdXrefCardNum;
  private String fdXrefData;
   
  public  FdXreffileRec(){
      fdXrefCardNum = FieldFormat.format(16, ValueConst.SPACE);
      fdXrefData = FieldFormat.format(34, ValueConst.SPACE);
  }
}