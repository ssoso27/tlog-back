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

    public SimplePlaceDTO create(SimplePlaceDTO dto) {
        return repository.save(dto.toPlace()).toSimpleDTO();
    }

    public SimplePlaceDTO update(SimplePlaceDTO dto) {
        System.out.println(dto.getDataCreated());
        System.out.println(dto.getLastUpdated());
        return repository.save(dto.toPlace()).toSimpleDTO();
    }
}
