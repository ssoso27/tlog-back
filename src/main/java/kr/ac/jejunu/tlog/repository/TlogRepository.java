package kr.ac.jejunu.tlog.repository;

import kr.ac.jejunu.tlog.entity.Tlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TlogRepository extends JpaRepository<Tlog, Long> {
}
