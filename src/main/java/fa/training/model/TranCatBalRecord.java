package fa.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "tran_cat_bal")
public class TranCatBalRecord {

 @EmbeddedId
  private  TranCatBalId id;

 @Column(name = "bal")
  private BigDecimal tranCatBal;
   
  public  TranCatBalRecord(){
      id = new TranCatBalId();
      tranCatBal = new BigDecimal(0);
  }
}