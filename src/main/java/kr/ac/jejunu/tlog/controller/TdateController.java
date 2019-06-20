package kr.ac.jejunu.tlog.controller;

import kr.ac.jejunu.tlog.dto.TdateDTO;
import kr.ac.jejunu.tlog.service.TdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tdate")
public class TdateController {

    @Autowired
    TdateService service;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void create(@ModelAttribute TdateDTO tdateDTO) {
        service.create(tdateDTO);
    }
}
