package kr.ac.jejunu.tlog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "memories")
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "place_id")
    private Integer placeId;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @Column(name = "order")
    private Integer order;

    @Column(name = "data_created")
    private LocalDateTime dateCreated;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
}
