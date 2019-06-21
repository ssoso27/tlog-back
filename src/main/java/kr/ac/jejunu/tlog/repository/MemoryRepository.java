package kr.ac.jejunu.tlog.repository;

import kr.ac.jejunu.tlog.entity.Memory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoryRepository extends JpaRepository<Memory, Long> {
    List<Memory> findAllByPlaceId(Long id);
}
