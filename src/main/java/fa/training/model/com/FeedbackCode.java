package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeedbackCode {

  private short severity;
  private short msgNo;
  private String caseSevCtl;
  private String facilityId;
  private int iSInfo;
   
  public  FeedbackCode(){
      severity = (short)0;
      msgNo = (short)0;
      caseSevCtl = ValueConst.SPACE;
      facilityId = FieldFormat.format(3, ValueConst.SPACE);
      iSInfo = 0;
  }
}