package kr.ac.jejunu.tlog.service;

import kr.ac.jejunu.tlog.entity.Tlog;
import kr.ac.jejunu.tlog.repository.TlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TlogService {
    @Autowired
    TlogRepository repository;

    public List<Tlog> list(Sort sort) {
        return repository.findAll(sort);
    }
}
