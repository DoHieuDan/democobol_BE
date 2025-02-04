package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WsTranTbl {

  private String wsTranNum;
  private String wsTranRest;
   
  public  WsTranTbl(){
      wsTranNum = FieldFormat.format(16, ValueConst.SPACE);
      wsTranRest = FieldFormat.format(318, ValueConst.SPACE);
  }
}