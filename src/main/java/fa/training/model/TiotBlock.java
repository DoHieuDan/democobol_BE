package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TiotBlock {

  private String tiotnjob;
  private String tiotjstp;
  private String tiotpstp;
   
  public  TiotBlock(){
      tiotnjob = FieldFormat.format(8, ValueConst.SPACE);
      tiotjstp = FieldFormat.format(8, ValueConst.SPACE);
      tiotpstp = FieldFormat.format(8, ValueConst.SPACE);
  }
}