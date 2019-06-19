package kr.ac.jejunu.tlog.repository;

import kr.ac.jejunu.tlog.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
}
