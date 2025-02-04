package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WsM03bArea {

  private String wsM03bDd;
  private String wsM03bOper;
  private String wsM03bRc;
  private String wsM03bKey;
  private short wsM03bKeyLn;
  private String wsM03bFldt;
   
  public  WsM03bArea(){
      wsM03bDd = FieldFormat.format(8, ValueConst.SPACE);
      wsM03bOper = ValueConst.SPACE;
      wsM03bRc = FieldFormat.format(2, ValueConst.SPACE);
      wsM03bKey = FieldFormat.format(25, ValueConst.SPACE);
      wsM03bKeyLn = (short)0;
      wsM03bFldt = FieldFormat.format(1000, ValueConst.SPACE);
  }
}