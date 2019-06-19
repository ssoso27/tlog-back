package kr.ac.jejunu.tlog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tlogs")
@NoArgsConstructor
@AllArgsConstructor
public class Tlog extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name="account_id", nullable = false)
    private Account account;

    @Column(name = "title")
    private String title;

    @Column(name = "background_img")
    private String backgroundImg;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "last_date")
    private LocalDate lastDate;
}
