package kr.ac.jejunu.tlog.entity;

import kr.ac.jejunu.tlog.dto.MemoryDTO;
import kr.ac.jejunu.tlog.dto.PlaceDTO;
import kr.ac.jejunu.tlog.dto.SimplePlaceDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="places")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Place extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Tdate.class)
    @JoinColumn(name="tdate_id", nullable = false)
    private Tdate tdate;

    @Column(name = "name")
    private String name;

    @Column(name = "seq")
    private Integer seq;

    public PlaceDTO toDTO(List<MemoryDTO> memories) {
        return PlaceDTO.builder()
                .id(id)
                .name(name)
                .seq(seq)
                .tdateId(tdate.getId())
                .memories(memories)
                .dataCreated(dataCreated)
                .lastUpdated(lastUpdated)
                .build();
    }

    public SimplePlaceDTO toSimpleDTO() {
        return SimplePlaceDTO.builder()
                .id(id)
                .name(name)
                .seq(seq)
                .tdateId(tdate.getId())
                .dataCreated(dataCreated)
                .lastUpdated(lastUpdated)
                .build();
    }
}
