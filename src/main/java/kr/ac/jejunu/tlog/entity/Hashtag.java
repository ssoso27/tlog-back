package kr.ac.jejunu.tlog.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="hashtags")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hashtag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Tlog.class)
    @JoinColumn(name="tlog_id", nullable = false)
    private Tlog tlog;

    @Column(name = "content")
    private String content;
}
