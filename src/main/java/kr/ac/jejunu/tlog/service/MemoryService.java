package kr.ac.jejunu.tlog.service;

import kr.ac.jejunu.tlog.dto.MemoryDTO;
import kr.ac.jejunu.tlog.entity.Memory;
import kr.ac.jejunu.tlog.repository.MemoryRepository;
import kr.ac.jejunu.tlog.util.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemoryService {
    @Autowired
    MemoryRepository repository;

    @Autowired
    FileUploader fileUploader;

    public MemoryDTO create(MemoryDTO memoryDTO) {
        String savedFileName = "";
        if (memoryDTO.getImage() != null) {
            savedFileName = fileUploader.saveFile(memoryDTO.getImage());
        }

        Memory memory = memoryDTO.toMemory();
        memory.setImage(savedFileName);
        return repository.save(memory).toDTO();
    }

    public MemoryDTO update(MemoryDTO memoryDTO) {
        Optional<Memory> originMemory = repository.findById(memoryDTO.getId());

        if (originMemory.isPresent()) {
            Memory newMemory = memoryDTO.toMemory();
            newMemory.setDataCreated(originMemory.get().getDataCreated());

            String savedFileName = "";
            if (memoryDTO.getImage() != null) {
                savedFileName = fileUploader.saveFile(memoryDTO.getImage());
            }
            newMemory.setImage(savedFileName);

            return repository.save(newMemory).toDTO();
        } else {
            return null;
        }
    }
}
