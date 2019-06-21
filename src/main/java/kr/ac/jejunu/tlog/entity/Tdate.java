package kr.ac.jejunu.tlog.entity;

import kr.ac.jejunu.tlog.dto.PlaceDTO;
import kr.ac.jejunu.tlog.dto.TdateDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tdates")
@Builder
public class Tdate extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date")
    private LocalDate date;

    @ManyToOne(targetEntity = Tlog.class)
    @JoinColumn(name="tlog_id", nullable = false)
    private Tlog tlog;

    public TdateDTO toDTO(List<PlaceDTO> placeDTOs) {
        return TdateDTO.builder()
                .id(id)
                .date(date)
                .tlogId(tlog.getId())
                .places(placeDTOs)
                .dataCreated(dataCreated)
                .lastUpdated(lastUpdated)
                .build();
    }
}
