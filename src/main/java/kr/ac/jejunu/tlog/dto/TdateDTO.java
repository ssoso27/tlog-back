package kr.ac.jejunu.tlog.dto;

import kr.ac.jejunu.tlog.entity.Tdate;
import kr.ac.jejunu.tlog.entity.Tlog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TdateDTO extends BaseDTO {
    private Long id;
    private Long tlogId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private List<PlaceDTO> places;

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
