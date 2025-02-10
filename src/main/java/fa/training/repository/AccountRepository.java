package fa.training.repository;

import fa.training.model.AccountRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountRecord, Long> {
}
