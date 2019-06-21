package kr.ac.jejunu.tlog.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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
}
