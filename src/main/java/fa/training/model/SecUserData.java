package fa.training.model;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.*;

@Setter
@Getter
@Builder
public class SecUserData {

  private String secUsrId;
  private String secUsrFname;
  private String secUsrLname;
  private String secUsrPwd;
  private String secUsrType;
  private String secUsrFiller;
   
//  public SecUserData(){
//      secUsrId = FieldFormat.format(8, ValueConst.SPACE);
//      secUsrFname = FieldFormat.format(20, ValueConst.SPACE);
//      secUsrLname = FieldFormat.format(20, ValueConst.SPACE);
//      secUsrPwd = FieldFormat.format(8, ValueConst.SPACE);
//      secUsrType = ValueConst.SPACE;
//      secUsrFiller = FieldFormat.format(23, ValueConst.SPACE);
//  }
}