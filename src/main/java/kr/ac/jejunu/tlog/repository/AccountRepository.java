package kr.ac.jejunu.tlog.repository;

import kr.ac.jejunu.tlog.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
