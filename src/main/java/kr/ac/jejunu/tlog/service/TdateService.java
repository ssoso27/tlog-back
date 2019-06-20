package kr.ac.jejunu.tlog.service;

import kr.ac.jejunu.tlog.dto.TdateDTO;
import kr.ac.jejunu.tlog.repository.TdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TdateService {
    
    @Autowired
    TdateRepository repository;

    public void create(TdateDTO tdateDTO) {
    }
}
