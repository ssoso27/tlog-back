package kr.ac.jejunu.tlog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {
    protected LocalDateTime dataCreated;
    protected LocalDateTime lastUpdated;
}
