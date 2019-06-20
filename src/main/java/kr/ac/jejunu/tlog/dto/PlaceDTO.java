package kr.ac.jejunu.tlog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlaceDTO extends BaseDTO {
    private Long id;
    private Long tdateId;
    private Long order;
    private String name;
}
