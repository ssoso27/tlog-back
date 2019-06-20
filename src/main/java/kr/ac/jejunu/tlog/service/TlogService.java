package kr.ac.jejunu.tlog.service;

import kr.ac.jejunu.tlog.dto.TlogDTO;
import kr.ac.jejunu.tlog.entity.Tlog;
import kr.ac.jejunu.tlog.exception.FileUploadException;
import kr.ac.jejunu.tlog.property.FileUploadProperties;
import kr.ac.jejunu.tlog.repository.TlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class TlogService {
    private final Path fileLocation;

    @Autowired
    TlogRepository repository;

    @Autowired
    public TlogService(FileUploadProperties prop) {
        this.fileLocation = Paths.get(prop.getUploadDir())
                .toAbsolutePath().normalize();
        System.out.println(this.fileLocation.toUri().toString());

        try {
            Files.createDirectories(this.fileLocation);
        }catch(Exception e) {
            throw new FileUploadException("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
        }
    }

    public List<Tlog> list(Sort sort) {
        return repository.findAll(sort);
    }

    public Long create(TlogDTO tlogDTO) {
        String fileName = StringUtils.cleanPath(tlogDTO.getBackgroundImg().getOriginalFilename());

        // 이미지 저장
        try {
            // 파일명에 부적합 문자가 있는지 확인한다.
            if(fileName.contains(".."))
                throw new FileUploadException("파일명에 부적합 문자가 포함되어 있습니다. " + fileName);
            Path targetLocation = this.fileLocation.resolve(fileName);
            Files.copy(tlogDTO.getBackgroundImg().getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        }catch(Exception e) {
            throw new FileUploadException("["+fileName+"] 파일 업로드에 실패하였습니다. 다시 시도하십시오.",e);
        }

        // Tlog 저장
        Tlog tlog = tlogDTO.toTlog();
        tlog.setBackgroundImg(fileName);
        repository.save(tlog);

        return tlog.getId();
    }
}
