package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RejectRecord {

  private String rejectTranData;
  private String validationTrailer;
   
  public  RejectRecord(){
      rejectTranData = FieldFormat.format(350, ValueConst.SPACE);
      validationTrailer = FieldFormat.format(80, ValueConst.SPACE);
  }
}