package fa.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "customers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customers {

    @Id
    @Column(name = "id")
    int cusId;

    @Column(name = "addr_country_cd")
    String addressCountryCode;

    @Column(name = "addr_line1")
    String addressLine1;

    @Column(name = "addr_line2")
    String addressLine2;

    @Column(name = "addr_line3")
    String addressLine3;

    @Column(name = "addr_state_cd")
    String addressStateCode;

    @Column(name = "addr_zip")
    String addressZip;

    @Column(name = "dob_yyyy_mm_dd")
    String dob;

    @Column(name = "eft_account_id")
    String eftAccountId;

    @Column(name = "fico_credit_score")
    int ficoCreditScore;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "middle_name")
    String midName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "govt_issued_id")
    String govtIssuedId;

    @Column(name = "phone_num1")
    String phoneNum1;

    @Column(name = "phone_num2")
    String phoneNum2;

    @Column(name = "pri_card_holder_ind")
    String priCardHolderInd;

    @Column(name = "ssn")
    int ssn;
}
