package fa.training.model;


import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class FdAcctfileRec {

  private long fdAcctId;
  private String fdAcctData;
   
  public  FdAcctfileRec(){
      fdAcctId = 0;
      fdAcctData = FieldFormat.format(289, ValueConst.SPACE);
  }
}