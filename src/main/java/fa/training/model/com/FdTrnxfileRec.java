package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FdTrnxfileRec {

  private String fdTrnxCard;
  private String fdTrnxId;
  private String fdAcctData;
   
  public  FdTrnxfileRec(){
      fdTrnxCard = FieldFormat.format(16, ValueConst.SPACE);
      fdTrnxId = FieldFormat.format(16, ValueConst.SPACE);
      fdAcctData = FieldFormat.format(318, ValueConst.SPACE);
  }
}