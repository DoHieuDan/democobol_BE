package fa.training.mapper;

import fa.training.model.AccountRecord;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.transform.LineAggregator;

import java.math.BigDecimal;

public class CBACT01CMapper {
    public static class CBACT01CLMapper implements LineMapper<AccountRecord> {
        @Override
        public AccountRecord mapLine(String line, int lineNumber) {
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setAcctId(Long.parseLong(line.substring(0, 11).trim()));
            accountRecord.setAcctActiveStatus(line.substring(11, 12).trim());
            accountRecord.setAcctCurrBal(parseSignedDecimal(line.substring(12, 24).trim()));
            accountRecord.setAcctCreditLimit(parseSignedDecimal(line.substring(24, 36).trim()));
            accountRecord.setAcctCashCreditLimit(parseSignedDecimal(line.substring(36, 48).trim()));
            accountRecord.setAcctOpenDate(line.substring(48, 58).trim());
            accountRecord.setAcctExpiraionDate(line.substring(58, 68).trim());
            accountRecord.setAcctReissueDate(line.substring(68, 78).trim());
            accountRecord.setAcctCurrCycCredit(parseSignedDecimal(line.substring(78, 90).trim()));
            accountRecord.setAcctCurrCycDebit(parseSignedDecimal(line.substring(90, 102).trim()));
            accountRecord.setAcctGroupId(line.substring(102, 112).trim());
            return accountRecord;
        }
    }

    public static class CBACT01CLAggregator implements LineAggregator<AccountRecord> {
        @Override
        public String aggregate(AccountRecord item) {
            return item.toString();
        }
    }

    private static BigDecimal parseSignedDecimal(String value) {
        char lastChar = value.charAt(value.length() - 1); // Ký tự cuối để xác định dấu
        String numericValue = value.substring(0, value.length() - 1); // Phần số
        // Kiểm tra ký tự cuối của các biến BigDecimal
        if ("{ABCDEFGHI".indexOf(lastChar) != -1) {
            return new BigDecimal(numericValue); // Nếu ký tự cuối thuộc "{ABCDEFGHI" thì là số dương
        } else if ("}JKLMNOPQR".indexOf(lastChar) != -1) {
            return new BigDecimal(numericValue).negate(); // Số âm
        } else {
            throw new IllegalArgumentException("Invalid COBOL format: " + value);
        }
    }
}
