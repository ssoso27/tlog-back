package kr.ac.jejunu.tlog.dto;

import kr.ac.jejunu.tlog.entity.Account;
import kr.ac.jejunu.tlog.entity.Tlog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TlogDTO extends BaseDTO {
    private Long id;
    private Long accountId;
    private String title;
    private MultipartFile backgroundImg;
    private String[] hashtags;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastDate;

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
