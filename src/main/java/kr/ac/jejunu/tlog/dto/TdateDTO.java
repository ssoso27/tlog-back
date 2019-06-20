package kr.ac.jejunu.tlog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TdateDTO extends BaseDTO {
    private Long id;
    private Long tlogId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private PlaceDTO[] places;
}
