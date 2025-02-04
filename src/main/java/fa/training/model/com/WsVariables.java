package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WsVariables {

  private String wsPgmname;
  private String wsTranid;
  private String wsMessage;
  private String wsUsrsecFile;
  private String wsErrFlg;
  private int wsRespCd;
  private int wsReasCd;
  private String wsUsrModified;
   
  public  WsVariables(){
      wsPgmname = FieldFormat.format(8, ValueConst.SPACE);
      wsTranid = FieldFormat.format(4, ValueConst.SPACE);
      wsMessage = FieldFormat.format(80, ValueConst.SPACE);
      wsUsrsecFile = FieldFormat.format(8, ValueConst.SPACE);
      wsErrFlg = ValueConst.SPACE;
      wsRespCd = 0;
      wsReasCd = 0;
      wsUsrModified = ValueConst.SPACE;
  }
}