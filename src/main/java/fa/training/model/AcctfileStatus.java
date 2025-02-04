package fa.training.model;

import fa.training.lib.constants.ValueConst;
import lombok.Getter;
import lombok.Setter;

public class AcctfileStatus {  

  @Getter
  @Setter
  private String acctfileStat1;
  @Getter
  @Setter
  private String acctfileStat2;
   
  public  AcctfileStatus(){
      acctfileStat1 = ValueConst.SPACE;
      acctfileStat2 = ValueConst.SPACE;
  }
}