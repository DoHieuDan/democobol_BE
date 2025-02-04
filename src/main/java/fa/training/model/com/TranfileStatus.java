package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TranfileStatus {

  private String tranfileStat1;
  private String tranfileStat2;
   
  public  TranfileStatus(){
      tranfileStat1 = ValueConst.SPACE;
      tranfileStat2 = ValueConst.SPACE;
  }
}