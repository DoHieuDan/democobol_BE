package fa.training.model.com;


import fa.training.lib.constants.ValueConst;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DalyrejsStatus {  


  private String dalyrejsStat1;

  private String dalyrejsStat2;
   
  public  DalyrejsStatus(){
      dalyrejsStat1 = ValueConst.SPACE;
      dalyrejsStat2 = ValueConst.SPACE;
  }
}