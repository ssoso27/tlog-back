package kr.ac.jejunu.tlog.entity;

import kr.ac.jejunu.tlog.dto.MemoryDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "memories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Place.class)
    @JoinColumn(name="place_id", nullable = false)
    private Place place;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @Column(name = "seq")
    private Long seq;

    public MemoryDTO toDTO() {
        return MemoryDTO.builder()
                .id(id)
                .placeId(place.getId())
                .content(content)
                .seq(seq)
                .imageUrl(image)
                .dataCreated(dataCreated)
                .lastUpdated(lastUpdated)
                .build();
    }
}
