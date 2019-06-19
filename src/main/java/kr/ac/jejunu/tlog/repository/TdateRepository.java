package kr.ac.jejunu.tlog.repository;

import kr.ac.jejunu.tlog.entity.Tdate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TdateRepository extends JpaRepository<Tdate, Long> {
}
