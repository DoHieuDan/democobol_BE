package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WsMessage {

  private String wsSeverity;
  private String filler1;
  private String wsMsgNo;
  private String filler2;
  private String wsResult;
  private String filler3;
  private String filler4;
  private String wsDate;
  private String filler5;
  private String filler6;
  private String wsDateFmt;
  private String filler7;
  private String filler8;
   
  public  WsMessage(){
      wsSeverity = FieldFormat.format(4, ValueConst.SPACE);
      filler1 = FieldFormat.format(11, ValueConst.SPACE);
      wsMsgNo = FieldFormat.format(4, ValueConst.SPACE);
      filler2 = ValueConst.SPACE;
      wsResult = FieldFormat.format(15, ValueConst.SPACE);
      filler3 = ValueConst.SPACE;
      filler4 = FieldFormat.format(9, ValueConst.SPACE);
      wsDate = FieldFormat.format(10, ValueConst.SPACE);
      filler5 = ValueConst.SPACE;
      filler6 = FieldFormat.format(10, ValueConst.SPACE);
      wsDateFmt = FieldFormat.format(10, ValueConst.SPACE);
      filler7 = ValueConst.SPACE;
      filler8 = FieldFormat.format(3, ValueConst.SPACE);
  }
}