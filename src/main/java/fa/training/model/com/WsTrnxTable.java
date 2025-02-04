package fa.training.model.com;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class WsTrnxTable {

  private ArrayList<WsCardTbl> wsCardTbl;
   
  public  WsTrnxTable(){
      this.wsCardTbl = new ArrayList<WsCardTbl>();
      for (int i = 0; i < 51; i++){
          wsCardTbl.add(new WsCardTbl());
      }
  }
}