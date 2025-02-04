package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class WsDateToTest {

  private short vstringLength;
  private ArrayList<String> vstringChar;
   
  public  WsDateToTest(){
      vstringLength = (short)0;
      this.vstringChar = new ArrayList<String>();
      for (int i = 0; i < 256; i++){
          vstringChar.add(ValueConst.SPACE);
      }
  }
}