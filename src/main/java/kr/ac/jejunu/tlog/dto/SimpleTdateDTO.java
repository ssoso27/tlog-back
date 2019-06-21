package kr.ac.jejunu.tlog.dto;

import kr.ac.jejunu.tlog.entity.Tdate;
import kr.ac.jejunu.tlog.entity.Tlog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleTdateDTO {

    private Long id;
    private Long tlogId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Tdate toTdate() {
        return Tdate.builder()
                .id(id)
                .date(date)
                .tlog(Tlog.builder().id(tlogId).build())
                .build();
    }
}