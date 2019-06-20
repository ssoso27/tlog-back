package kr.ac.jejunu.tlog.controller;

import kr.ac.jejunu.tlog.dto.TlogDTO;
import kr.ac.jejunu.tlog.entity.Tlog;
import kr.ac.jejunu.tlog.service.TlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Long create(@ModelAttribute TlogDTO tlogDTO) {
        return service.create(tlogDTO);
    }
}
