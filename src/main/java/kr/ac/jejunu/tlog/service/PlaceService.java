package kr.ac.jejunu.tlog.service;

import kr.ac.jejunu.tlog.dto.SimplePlaceDTO;
import kr.ac.jejunu.tlog.entity.Place;
import kr.ac.jejunu.tlog.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    @Autowired
    PlaceRepository repository;

    public Long create(SimplePlaceDTO dto) {
        Place place = dto.toPlace();
        repository.save(place);
        return place.getId();
    }
}
