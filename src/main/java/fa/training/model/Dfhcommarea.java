package fa.training.model;


import java.util.ArrayList;

import fa.training.lib.constants.ValueConst;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Dfhcommarea {

  private ArrayList<String> lkCommarea;
   
  public  Dfhcommarea(){
      this.lkCommarea = new ArrayList<String>();
      for (int i = 0; i < 32767; i++){
          lkCommarea.add(ValueConst.SPACE);
      }
  }
}