package kr.ac.jejunu.tlog.dto;

import kr.ac.jejunu.tlog.entity.Memory;
import kr.ac.jejunu.tlog.entity.Place;
import kr.ac.jejunu.tlog.entity.Tdate;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlaceDTO extends BaseDTO {
    private Long id;
    private Long tdateId;
    private Integer seq;
    private String name;
    private List<MemoryDTO> memories;

    @Builder
    public PlaceDTO(LocalDateTime dataCreated, LocalDateTime lastUpdated, Long id, Long tdateId, Integer seq, String name, List<MemoryDTO> memories) {
        super(dataCreated, lastUpdated);
        this.id = id;
        this.tdateId = tdateId;
        this.seq = seq;
        this.name = name;
        this.memories = memories;
    }

    public Place toPlace() {
        return Place.builder()
                .id(id)
                .name(name)
                .seq(seq)
                .tdate(Tdate.builder().id(tdateId).build())
                .build();
    }

//    public ArrayList<Memory> getMemoryEntities() {
//        ArrayList<Memory> list = new ArrayList<Memory>();
//        if (memories != null) {
//            for (MemoryDTO dto: memories) {
//                list.add(dto.toMemory());
//            }
//        }
//        return list;
//    }
}
