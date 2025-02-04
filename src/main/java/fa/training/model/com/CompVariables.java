package fa.training.model.com;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompVariables {  

  private short crCnt;

  private short trCnt;

  private short crJmp;

  private short trJmp;
   
  public  CompVariables(){
      crCnt = (short)0;
      trCnt = (short)0;
      crJmp = (short)0;
      trJmp = (short)0;
  }
}