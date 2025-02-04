package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IoStatus {

  private String ioStat1;
  private String ioStat2;
   
  public  IoStatus(){
      ioStat1 = ValueConst.SPACE;
      ioStat2 = ValueConst.SPACE;
  }
}