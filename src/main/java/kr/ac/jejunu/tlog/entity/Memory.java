package kr.ac.jejunu.tlog.entity;

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

    @Column(name = "order")
    private Long order;
}
