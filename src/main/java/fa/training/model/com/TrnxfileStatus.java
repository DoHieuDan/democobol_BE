package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TrnxfileStatus {

  private String trnxfileStat1;
  private String trnxfileStat2;
   
  public  TrnxfileStatus(){
      trnxfileStat1 = ValueConst.SPACE;
      trnxfileStat2 = ValueConst.SPACE;
  }
}