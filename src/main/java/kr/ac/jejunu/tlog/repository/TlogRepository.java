package kr.ac.jejunu.tlog.repository;

import kr.ac.jejunu.tlog.entity.Tlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TlogRepository extends JpaRepository<Tlog, Long> {
}
