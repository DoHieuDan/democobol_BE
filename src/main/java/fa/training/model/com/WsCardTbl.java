package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class WsCardTbl {

  private String wsCardNum;
  private ArrayList<WsTranTbl> wsTranTbl;
   
  public  WsCardTbl(){
      wsCardNum = FieldFormat.format(16, ValueConst.SPACE);
      this.wsTranTbl = new ArrayList<WsTranTbl>();
      for (int i = 0; i < 10; i++){
          wsTranTbl.add(new WsTranTbl());
      }
  }
}