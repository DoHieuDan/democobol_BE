package fa.training.model;

import fa.training.lib.constants.ValueConst;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TcatbalfStatus {

  private String tcatbalfStat1;
  private String tcatbalfStat2;
   
  public  TcatbalfStatus(){
      tcatbalfStat1 = ValueConst.SPACE;
      tcatbalfStat2 = ValueConst.SPACE;
  }
}