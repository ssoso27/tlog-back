package kr.ac.jejunu.tlog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="places")
@NoArgsConstructor
@AllArgsConstructor
public class Place extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = TDate.class)
    @JoinColumn(name="tdate_id", nullable = false)
    private Integer tdateId;

    @Column(name = "name")
    private String name;

    @Column(name = "trip_date")
    private LocalDateTime tripDate;

    @Column(name = "order")
    private Integer order;
}
