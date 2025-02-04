package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PsaBlock {

  private String filler1;
  private String tcbPoint;
   
  public  PsaBlock(){
      filler1 = FieldFormat.format(536, ValueConst.SPACE);
      tcbPoint = ValueConst.SPACE;
  }
}