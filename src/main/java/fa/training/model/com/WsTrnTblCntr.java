package fa.training.model.com;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class WsTrnTblCntr {

  private short[] wsTrnTblCtr = new short[51];
   
  public  WsTrnTblCntr(){
      for (int i = 0; i < 51; i++){
          wsTrnTblCtr[i] = (short)0;
      }
  }
}