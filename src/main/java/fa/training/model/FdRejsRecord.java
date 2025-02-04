package fa.training.model;


import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FdRejsRecord {

  private String fdRejectRecord;
  private String fdValidationTrailer;
   
  public  FdRejsRecord(){
      fdRejectRecord = FieldFormat.format(350, ValueConst.SPACE);
      fdValidationTrailer = FieldFormat.format(80, ValueConst.SPACE);
  }
}