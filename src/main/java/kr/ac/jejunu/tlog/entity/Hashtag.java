package kr.ac.jejunu.tlog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="hashtags")
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tlog_id")
    private Integer tlogId;

    @Column(name = "content")
    private String content;

    @Column(name = "data_created")
    private LocalDateTime dateCreated;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
}
