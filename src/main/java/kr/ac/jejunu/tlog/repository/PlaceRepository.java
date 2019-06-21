package kr.ac.jejunu.tlog.repository;

import kr.ac.jejunu.tlog.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAllByTdateId(Long id);
}
