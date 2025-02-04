package fa.training.model;


import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class FdCustfileRec {

  private String fdCustId;
  private String fdCustData;
   
  public  FdCustfileRec(){
      fdCustId = FieldFormat.format(9, ValueConst.SPACE);
      fdCustData = FieldFormat.format(491, ValueConst.SPACE);
  }
}