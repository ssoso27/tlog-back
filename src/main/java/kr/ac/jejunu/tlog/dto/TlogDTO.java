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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastDate;

    public Tlog toTlog() {
        Tlog tlog = new Tlog();

        tlog.setId(this.id);
        tlog.setAccount(Account.builder().id(this.accountId).build());
        tlog.setTitle(this.title);
        tlog.setBackgroundImg(this.backgroundImg.getOriginalFilename());
        tlog.setStartDate(this.startDate);
        tlog.setLastDate(this.lastDate);
        tlog.setDataCreated(this.dataCreated);
        tlog.setLastUpdated(this.lastUpdated);

        return tlog;
    }
}
