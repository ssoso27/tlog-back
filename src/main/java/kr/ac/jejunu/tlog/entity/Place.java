package kr.ac.jejunu.tlog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tlog_id")
    private Integer tlogId;

    @Column(name = "name")
    private String name;

    @Column(name = "trip_date")
    private LocalDateTime tripDate;

    @Column(name = "order")
    private Integer order;

    @Column(name = "data_created")
    private LocalDateTime dateCreated;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
}
