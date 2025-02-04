package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TiotEntry {

  private String tioLen;
  private String filler1;
  private String tiocddnm;
  private String filler2;
  private String ucbAddr;
  private String filler1OfTiotEntry;
   
  public  TiotEntry(){
      tioLen = ValueConst.SPACE;
      filler1 = FieldFormat.format(3, ValueConst.SPACE);
      tiocddnm = FieldFormat.format(8, ValueConst.SPACE);
      filler2 = FieldFormat.format(5, ValueConst.SPACE);
      ucbAddr = FieldFormat.format(3, ValueConst.SPACE);
      filler1OfTiotEntry = FieldFormat.format(4, ValueConst.SPACE);
  }
}