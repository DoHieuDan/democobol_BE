package fa.training.model;


import fa.training.lib.constants.ValueConst;
import fa.training.lib.util.FieldFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "daily_tran")
public class DalytranRecord {
    @Id
    private String dalytranId;

    @Column(name = "type_cd")
    private String dalytranTypeCd;

    @Column(name = "cat_cd")
    private int dalytranCatCd;

    @Column(name = "source")
    private String dalytranSource;

    @Column(name = "description")
    private String dalytranDesc;

    @Column(name = "amt")
    private BigDecimal dalytranAmt;

    @Column(name = "merchant_id")
    private int dalytranMerchantId;

    @Column(name = "merchant_name")
    private String dalytranMerchantName;

    @Column(name = "merchant_city")
    private String dalytranMerchantCity;

    @Column(name = "merchant_zip")
    private String dalytranMerchantZip;

    @Column(name = "card_num")
    private String dalytranCardNum;

    @Column(name = "orig_ts")
    private String dalytranOrigTs;

    @Column(name = "proc_ts")
    private String dalytranProcTs;

    public DalytranRecord() {
        dalytranId = FieldFormat.format(16, ValueConst.SPACE);
        dalytranTypeCd = FieldFormat.format(2, ValueConst.SPACE);
        dalytranCatCd = (short) 0;
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
    }
}