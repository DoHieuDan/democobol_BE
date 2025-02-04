package fa.training.model.com;


import fa.training.lib.constants.ValueConst;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustfileStatus {  

  private String custfileStat1;
  private String custfileStat2;
   
  public  CustfileStatus(){
      custfileStat1 = ValueConst.SPACE;
      custfileStat2 = ValueConst.SPACE;
  }
}