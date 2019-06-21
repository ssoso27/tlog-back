package kr.ac.jejunu.tlog.controller;

import kr.ac.jejunu.tlog.dto.SimplePlaceDTO;
import kr.ac.jejunu.tlog.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    PlaceService service;

    @PostMapping
    public SimplePlaceDTO create(@RequestBody SimplePlaceDTO dto) {
        return service.create(dto);
    }

    @PutMapping
    public SimplePlaceDTO update(@RequestBody SimplePlaceDTO dto) { return service.update(dto); }
}
