package fa.training.model.com;

import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomerRecord {  


  private int custId;

  private String custFirstName;

  private String custMiddleName;

  private String custLastName;

  private String custAddrLine1;

  private String custAddrLine2;

  private String custAddrLine3;

  private String custAddrStateCd;

  private String custAddrCountryCd;

  private String custAddrZip;

  private String custPhoneNum1;

  private String custPhoneNum2;

  private int custSsn;

  private String custGovtIssuedId;

  private String custDobYyyymmdd;

  private String custEftAccountId;

  private String custPriCardHolderInd;

  private short custFicoCreditScore;

  private String filler1;
   
  public  CustomerRecord(){
      custId = 0;
      custFirstName = FieldFormat.format(25, ValueConst.SPACE);
      custMiddleName = FieldFormat.format(25, ValueConst.SPACE);
      custLastName = FieldFormat.format(25, ValueConst.SPACE);
      custAddrLine1 = FieldFormat.format(50, ValueConst.SPACE);
      custAddrLine2 = FieldFormat.format(50, ValueConst.SPACE);
      custAddrLine3 = FieldFormat.format(50, ValueConst.SPACE);
      custAddrStateCd = FieldFormat.format(2, ValueConst.SPACE);
      custAddrCountryCd = FieldFormat.format(3, ValueConst.SPACE);
      custAddrZip = FieldFormat.format(10, ValueConst.SPACE);
      custPhoneNum1 = FieldFormat.format(15, ValueConst.SPACE);
      custPhoneNum2 = FieldFormat.format(15, ValueConst.SPACE);
      custSsn = 0;
      custGovtIssuedId = FieldFormat.format(20, ValueConst.SPACE);
      custDobYyyymmdd = FieldFormat.format(10, ValueConst.SPACE);
      custEftAccountId = FieldFormat.format(10, ValueConst.SPACE);
      custPriCardHolderInd = ValueConst.SPACE;
      custFicoCreditScore = (short)0;
      filler1 = FieldFormat.format(168, ValueConst.SPACE);
  }
}