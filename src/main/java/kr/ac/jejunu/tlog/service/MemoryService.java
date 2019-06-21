package kr.ac.jejunu.tlog.service;

import kr.ac.jejunu.tlog.dto.MemoryDTO;
import kr.ac.jejunu.tlog.entity.Memory;
import kr.ac.jejunu.tlog.repository.MemoryRepository;
import kr.ac.jejunu.tlog.util.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoryService {
    @Autowired
    MemoryRepository repository;

    @Autowired
    FileUploader fileUploader;

    public Long create(MemoryDTO memoryDTO) {
        String savedFileName = "";
        if (memoryDTO.getImage() != null) {
            savedFileName = fileUploader.saveFile(memoryDTO.getImage());
        }

        Memory memory = memoryDTO.toMemory();
        memory.setImage(savedFileName);
        return repository.save(memory).getId();
    }
}
