package kr.ac.jejunu.tlog.repository;

import kr.ac.jejunu.tlog.entity.Memory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoryRepository extends JpaRepository<Memory, Long> {
}
