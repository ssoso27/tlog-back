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
    private Long id;

    @ManyToOne(targetEntity = Tdate.class)
    @JoinColumn(name="tdate_id", nullable = false)
    private Tdate tdate;

    @Column(name = "name")
    private String name;

    @Column(name = "order")
    private Integer order;
}
