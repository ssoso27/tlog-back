package kr.ac.jejunu.tlog.dto;

import kr.ac.jejunu.tlog.entity.Place;
import kr.ac.jejunu.tlog.entity.Tdate;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class SimplePlaceDTO extends BaseDTO {
    private Long id;
    private Long tdateId;
    private Integer seq;
    private String name;

    @Builder
    public SimplePlaceDTO(LocalDateTime dataCreated, LocalDateTime lastUpdated, Long id, Long tdateId, Integer seq, String name) {
        super(dataCreated, lastUpdated);
        this.id = id;
        this.tdateId = tdateId;
        this.seq = seq;
        this.name = name;
    }

    public Place toPlace() {
        Place place = Place.builder()
                    .id(id)
                    .name(name)
                    .seq(seq)
                    .tdate(Tdate.builder().id(tdateId).build())
                    .build();

        if (this.dataCreated != null) place.setDataCreated(this.dataCreated);
        if (this.lastUpdated != null) place.setLastUpdated(this.lastUpdated);

        return place;
    }
}
