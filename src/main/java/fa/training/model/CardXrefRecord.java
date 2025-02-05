package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardXrefRecord {

  private String xrefCardNum;
  private int xrefCustId;
  private long xrefAcctId;
  private String filler1;
   
  public  CardXrefRecord(){
      xrefCardNum = FieldFormat.format(16, ValueConst.SPACE);
      xrefCustId = 0;
      xrefAcctId = 0;
      filler1 = FieldFormat.format(14, ValueConst.SPACE);
  }
}