package kr.ac.jejunu.tlog.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {
    protected LocalDateTime dataCreated;
    protected LocalDateTime lastUpdated;
}
