package kr.ac.jejunu.tlog.dto;

import kr.ac.jejunu.tlog.entity.Tdate;
import kr.ac.jejunu.tlog.entity.Tlog;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TdateDTO extends BaseDTO {
    private Long id;
    private Long tlogId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private List<PlaceDTO> places;

    @Builder
    public TdateDTO(LocalDateTime dataCreated, LocalDateTime lastUpdated, Long id, Long tlogId, LocalDate date, List<PlaceDTO> places) {
        super(dataCreated, lastUpdated);
        this.id = id;
        this.tlogId = tlogId;
        this.date = date;
        this.places = places;
    }

    public Tdate toTdate() {
        return Tdate.builder()
                .id(id)
                .date(date)
                .tlog(Tlog.builder().id(tlogId).build())
                .build();
    }

//    public ArrayList<Place> getPlaceEntities() {
//        ArrayList<Place> list = new ArrayList<Place>();
//        if (places != null) {
//            for (PlaceDTO dto: places) {
//                list.add(dto.toPlace());
//            }
//        }
//        return list;
//    }
}
