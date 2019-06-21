package kr.ac.jejunu.tlog.controller;

import kr.ac.jejunu.tlog.dto.MemoryDTO;
import kr.ac.jejunu.tlog.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memories")
public class MemoryController {
    @Autowired
    MemoryService service;


    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public MemoryDTO create(@ModelAttribute MemoryDTO memoryDTO) {
        return service.create(memoryDTO);
    }

    @PutMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public MemoryDTO update(@ModelAttribute MemoryDTO memoryDTO) { return service.update(memoryDTO); }
}
