package fa.training.model.com;


import java.math.BigDecimal;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class DalytranRecord {

  private String dalytranId;
  private String dalytranTypeCd;
  private short dalytranCatCd;
  private String dalytranSource;
  private String dalytranDesc;
  private BigDecimal dalytranAmt;
  private int dalytranMerchantId;
  private String dalytranMerchantName;
  private String dalytranMerchantCity;
  private String dalytranMerchantZip;
  private String dalytranCardNum;
  private String dalytranOrigTs;
  private String dalytranProcTs;
  private String filler1;
   
  public  DalytranRecord(){
      dalytranId = FieldFormat.format(16, ValueConst.SPACE);
      dalytranTypeCd = FieldFormat.format(2, ValueConst.SPACE);
      dalytranCatCd = (short)0;
      dalytranSource = FieldFormat.format(10, ValueConst.SPACE);
      dalytranDesc = FieldFormat.format(100, ValueConst.SPACE);
      dalytranAmt = new BigDecimal(0);
      dalytranMerchantId = 0;
      dalytranMerchantName = FieldFormat.format(50, ValueConst.SPACE);
      dalytranMerchantCity = FieldFormat.format(50, ValueConst.SPACE);
      dalytranMerchantZip = FieldFormat.format(10, ValueConst.SPACE);
      dalytranCardNum = FieldFormat.format(16, ValueConst.SPACE);
      dalytranOrigTs = FieldFormat.format(26, ValueConst.SPACE);
      dalytranProcTs = FieldFormat.format(26, ValueConst.SPACE);
      filler1 = FieldFormat.format(20, ValueConst.SPACE);
  }
}