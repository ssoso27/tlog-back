package kr.ac.jejunu.tlog.repository;

import kr.ac.jejunu.tlog.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
