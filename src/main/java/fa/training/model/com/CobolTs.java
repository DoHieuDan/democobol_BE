package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CobolTs {  

  
  private String cobYyyy;

  private String cobMm;

  private String cobDd;
  
  private String cobHh;
  
  private String cobMin;

  private String cobSs;
  
  private String cobMil;
  
  private String cobRest;
   
  public  CobolTs(){
      cobYyyy = FieldFormat.format(4, ValueConst.SPACE);
      cobMm = FieldFormat.format(2, ValueConst.SPACE);
      cobDd = FieldFormat.format(2, ValueConst.SPACE);
      cobHh = FieldFormat.format(2, ValueConst.SPACE);
      cobMin = FieldFormat.format(2, ValueConst.SPACE);
      cobSs = FieldFormat.format(2, ValueConst.SPACE);
      cobMil = FieldFormat.format(2, ValueConst.SPACE);
      cobRest = FieldFormat.format(5, ValueConst.SPACE);
  }
}