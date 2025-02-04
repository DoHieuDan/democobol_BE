package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TcbBlock {

  private String filler1;
  private String tiotPoint;
   
  public  TcbBlock(){
      filler1 = FieldFormat.format(12, ValueConst.SPACE);
      tiotPoint = ValueConst.SPACE;
  }
}