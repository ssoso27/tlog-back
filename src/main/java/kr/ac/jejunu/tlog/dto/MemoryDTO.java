package kr.ac.jejunu.tlog.dto;

import kr.ac.jejunu.tlog.entity.Memory;
import kr.ac.jejunu.tlog.entity.Place;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MemoryDTO extends BaseDTO {
    private Long id;
    private Long placeId;
    private Long seq;
    private MultipartFile image;
    private String content;

    @Builder
    public MemoryDTO(LocalDateTime dataCreated, LocalDateTime lastUpdated, Long id, Long placeId, Long seq, MultipartFile image, String content) {
        super(dataCreated, lastUpdated);
        this.id = id;
        this.placeId = placeId;
        this.seq = seq;
        this.image = image;
        this.content = content;
    }

    public Memory toMemory() {
        Memory memory = Memory.builder()
                        .id(id)
                        .content(content)
                        .seq(seq)
                        .place(Place.builder().id(placeId).build())
                        .build();
        if (image != null) memory.setImage(image.getOriginalFilename());
        return memory;
    }
}
