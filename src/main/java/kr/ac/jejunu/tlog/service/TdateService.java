package kr.ac.jejunu.tlog.service;

import kr.ac.jejunu.tlog.dto.MemoryDTO;
import kr.ac.jejunu.tlog.dto.PlaceDTO;
import kr.ac.jejunu.tlog.dto.SimpleTdateDTO;
import kr.ac.jejunu.tlog.dto.TdateDTO;
import kr.ac.jejunu.tlog.entity.Memory;
import kr.ac.jejunu.tlog.entity.Place;
import kr.ac.jejunu.tlog.entity.Tdate;
import kr.ac.jejunu.tlog.repository.MemoryRepository;
import kr.ac.jejunu.tlog.repository.PlaceRepository;
import kr.ac.jejunu.tlog.repository.TdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TdateService {
    
    @Autowired
    TdateRepository repository;

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    MemoryRepository memoryRepository;

    public Long create(SimpleTdateDTO tdateDTO) {
        Tdate tdate = tdateDTO.toTdate();
        repository.save(tdate);

        return tdate.getId();
    }

    public TdateDTO get(Long id) {
        Optional<Tdate> tdate = repository.findById(id);
        if (tdate.isPresent()) {
            List<PlaceDTO> placeDTOs = new ArrayList<>();
            List<Place> placeList = placeRepository.findAllByTdateId(tdate.get().getId());

            for (Place place : placeList) {
                List<MemoryDTO> memoryDTOs = new ArrayList<>();
                List<Memory> memoryList = memoryRepository.findAllByPlaceId(place.getId());

                for (Memory memory : memoryList) {
                    memoryDTOs.add(memory.toDTO());
                }
                placeDTOs.add(place.toDTO(memoryDTOs));
            }

            return tdate.get().toDTO(placeDTOs);
        } else {
            return null;
        }
    }
}
