package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LkM03bArea {

  private String lkM03bDd;
  private String lkM03bOper;
  private String lkM03bRc;
  private String lkM03bKey;
  private short lkM03bKeyLn;
  private String lkM03bFldt;
   
  public  LkM03bArea(){
      lkM03bDd = FieldFormat.format(8, ValueConst.SPACE);
      lkM03bOper = ValueConst.SPACE;
      lkM03bRc = FieldFormat.format(2, ValueConst.SPACE);
      lkM03bKey = FieldFormat.format(25, ValueConst.SPACE);
      lkM03bKeyLn = (short)0;
      lkM03bFldt = FieldFormat.format(1000, ValueConst.SPACE);
  }
}