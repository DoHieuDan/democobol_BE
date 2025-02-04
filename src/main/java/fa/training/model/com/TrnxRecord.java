package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class TrnxRecord {

  private String trnxCardNum;
  private String trnxId;
  private String trnxTypeCd;
  private short trnxCatCd;
  private String trnxSource;
  private String trnxDesc;
  private BigDecimal trnxAmt;
  private int trnxMerchantId;
  private String trnxMerchantName;
  private String trnxMerchantCity;
  private String trnxMerchantZip;
  private String trnxOrigTs;
  private String trnxProcTs;
  private String filler1;
   
  public  TrnxRecord(){
      trnxCardNum = FieldFormat.format(16, ValueConst.SPACE);
      trnxId = FieldFormat.format(16, ValueConst.SPACE);
      trnxTypeCd = FieldFormat.format(2, ValueConst.SPACE);
      trnxCatCd = (short)0;
      trnxSource = FieldFormat.format(10, ValueConst.SPACE);
      trnxDesc = FieldFormat.format(100, ValueConst.SPACE);
      trnxAmt = new BigDecimal(0);
      trnxMerchantId = 0;
      trnxMerchantName = FieldFormat.format(50, ValueConst.SPACE);
      trnxMerchantCity = FieldFormat.format(50, ValueConst.SPACE);
      trnxMerchantZip = FieldFormat.format(10, ValueConst.SPACE);
      trnxOrigTs = FieldFormat.format(26, ValueConst.SPACE);
      trnxProcTs = FieldFormat.format(26, ValueConst.SPACE);
      filler1 = FieldFormat.format(20, ValueConst.SPACE);
  }
}