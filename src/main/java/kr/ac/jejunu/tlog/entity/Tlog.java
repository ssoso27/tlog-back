package kr.ac.jejunu.tlog.entity;

import kr.ac.jejunu.tlog.dto.TlogDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tlogs")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public TlogDTO toDTO(String[] hashtagList) {
        return TlogDTO.builder()
                .id(id)
                .accountId(account.getId())
                .title(title)
                .imageUrl(backgroundImg)
                .hashtags(hashtagList)
                .startDate(startDate)
                .lastDate(lastDate)
                .dataCreated(dataCreated)
                .lastUpdated(lastUpdated)
                .build();
    }
}
