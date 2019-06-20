package kr.ac.jejunu.tlog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class MemoryDTO extends BaseDTO {
    private Long id;
    private Long placeId;
    private Long order;
    private MultipartFile image;
    private String content;
}
