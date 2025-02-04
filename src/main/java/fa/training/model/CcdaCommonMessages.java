package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

public class CcdaCommonMessages {  

  @Getter
  @Setter
  private String ccdaMsgThankYou;
  @Getter
  @Setter
  private String ccdaMsgInvalidKey;
   
  public  CcdaCommonMessages(){
      ccdaMsgThankYou = FieldFormat.format(50, ValueConst.SPACE);
      ccdaMsgInvalidKey = FieldFormat.format(50, ValueConst.SPACE);
  }
}