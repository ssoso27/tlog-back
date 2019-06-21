package kr.ac.jejunu.tlog.controller;

import kr.ac.jejunu.tlog.dto.SimplePlaceDTO;
import kr.ac.jejunu.tlog.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    PlaceService service;

    @PostMapping
    public Long create(@RequestBody SimplePlaceDTO dto) {
        return service.create(dto);
    }
}
