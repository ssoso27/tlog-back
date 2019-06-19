package kr.ac.jejunu.tlog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Column(name = "data_created")
    protected LocalDateTime dateCreated;

    @Column(name = "last_updated")
    protected LocalDateTime lastUpdated;
}
