package kr.ac.jejunu.tlog.controller;

import kr.ac.jejunu.tlog.dto.SimpleTdateDTO;
import kr.ac.jejunu.tlog.dto.TdateDTO;
import kr.ac.jejunu.tlog.service.TdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tdate")
public class TdateController {

    @Autowired
    TdateService service;

    @PostMapping
    public Long create(@RequestBody SimpleTdateDTO tdateDTO) {
        return service.create(tdateDTO);
    }

    @GetMapping("/{id}")
    public TdateDTO get(@PathVariable Long id) {
        return service.get(id);
    }
}
