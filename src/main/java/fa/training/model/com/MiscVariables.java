package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class MiscVariables {

  private String wsFlDd;
  private BigDecimal wsTrnAmt;
  private String wsSaveCard;
  private String endOfFile;
   
  public  MiscVariables(){
      wsFlDd = FieldFormat.format(8, ValueConst.SPACE);
      wsTrnAmt = new BigDecimal(0);
      wsSaveCard = FieldFormat.format(16, ValueConst.SPACE);
      endOfFile = ValueConst.SPACE;
  }
}