package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WsValidationTrailer {

  private short wsValidationFailReason;
  private String wsValidationFailReasonDesc;
   
  public  WsValidationTrailer(){
      wsValidationFailReason = (short)0;
      wsValidationFailReasonDesc = FieldFormat.format(76, ValueConst.SPACE);
  }
}