package kr.ac.jejunu.tlog.controller;

import kr.ac.jejunu.tlog.entity.Tlog;
import kr.ac.jejunu.tlog.service.TlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tlog")
public class TlogController {

    @Autowired
    TlogService service;

    @GetMapping
    public List<Tlog> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "dataCreated");
        return service.list(sort);
    }
}
