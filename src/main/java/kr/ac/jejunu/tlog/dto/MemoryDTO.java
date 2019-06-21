package kr.ac.jejunu.tlog.dto;

import kr.ac.jejunu.tlog.entity.Memory;
import kr.ac.jejunu.tlog.entity.Place;
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
    private Long seq;
    private MultipartFile image;
    private String content;

    public Memory toMemory() {
        return Memory.builder()
                .id(id)
                .content(content)
                .seq(seq)
                .place(Place.builder().id(placeId).build())
                .image(image.getOriginalFilename())
                .build();
    }
}
