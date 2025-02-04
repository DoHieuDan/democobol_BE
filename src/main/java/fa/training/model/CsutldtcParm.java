package fa.training.model;


import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CsutldtcParm {  

  private String csutldtcDate;
  private String csutldtcDateFormat;
  private String csutldtcResultSevCd;
  private String filler1;
  private String csutldtcResultMsgNum;
  private String csutldtcResultMsg;
   
  public  CsutldtcParm(){
      csutldtcDate = FieldFormat.format(10, ValueConst.SPACE);
      csutldtcDateFormat = FieldFormat.format(10, ValueConst.SPACE);
      csutldtcResultSevCd = FieldFormat.format(4, ValueConst.SPACE);
      filler1 = FieldFormat.format(11, ValueConst.SPACE);
      csutldtcResultMsgNum = FieldFormat.format(4, ValueConst.SPACE);
      csutldtcResultMsg = FieldFormat.format(61, ValueConst.SPACE);
  }
}