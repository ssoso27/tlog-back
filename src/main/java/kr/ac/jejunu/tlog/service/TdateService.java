package kr.ac.jejunu.tlog.service;

import kr.ac.jejunu.tlog.dto.SimpleTdateDTO;
import kr.ac.jejunu.tlog.entity.Tdate;
import kr.ac.jejunu.tlog.repository.TdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TdateService {
    
    @Autowired
    TdateRepository repository;
    public Long create(SimpleTdateDTO tdateDTO) {
        Tdate tdate = tdateDTO.toTdate();
        repository.save(tdate);

        return tdate.getId();
    }
}
