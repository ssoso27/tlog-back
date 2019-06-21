package kr.ac.jejunu.tlog.dto;

import kr.ac.jejunu.tlog.entity.Account;
import kr.ac.jejunu.tlog.entity.Tlog;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TlogDTO extends BaseDTO {
    private Long id;
    private Long accountId;
    private String title;
    private MultipartFile backgroundImg;
    private String imageUrl;
    private String[] hashtags;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastDate;

    @Builder
    public TlogDTO(LocalDateTime dataCreated, LocalDateTime lastUpdated, Long id, Long accountId, String title, MultipartFile backgroundImg, String imageUrl, String[] hashtags, LocalDate startDate, LocalDate lastDate) {
        super(dataCreated, lastUpdated);
        this.id = id;
        this.accountId = accountId;
        this.title = title;
        this.backgroundImg = backgroundImg;
        this.imageUrl = imageUrl;
        this.hashtags = hashtags;
        this.startDate = startDate;
        this.lastDate = lastDate;
    }

    public Tlog toTlog() {
        return Tlog.builder()
                .id(id)
                .account(Account.builder().id(this.accountId).build())
                .title(title)
                .startDate(startDate)
                .lastDate(lastDate)
                .build();
    }
}
