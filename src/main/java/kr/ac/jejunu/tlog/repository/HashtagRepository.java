package kr.ac.jejunu.tlog.repository;

import kr.ac.jejunu.tlog.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    List<Hashtag> findAllByTlogId(Long id);
}
