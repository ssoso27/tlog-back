package kr.ac.jejunu.tlog.dto;

import kr.ac.jejunu.tlog.entity.Place;
import kr.ac.jejunu.tlog.entity.Tdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimplePlaceDTO {
    private Long id;
    private Long tdateId;
    private Integer seq;
    private String name;

    public Place toPlace() {
        return Place.builder()
                .id(id)
                .name(name)
                .seq(seq)
                .tdate(Tdate.builder().id(tdateId).build())
                .build();
    }
}
