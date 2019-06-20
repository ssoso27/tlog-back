package kr.ac.jejunu.tlog.dto;

import kr.ac.jejunu.tlog.entity.Memory;
import kr.ac.jejunu.tlog.entity.Place;
import kr.ac.jejunu.tlog.entity.Tdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class PlaceDTO extends BaseDTO {
    private Long id;
    private Long tdateId;
    private Long order;
    private String name;
    private MemoryDTO[] memories;

    public Place toPlace() {
        return Place.builder()
                .id(id)
                .name(name)
                .order(order)
                .tdate(Tdate.builder().id(tdateId).build())
                .build();
    }

    public ArrayList<Memory> getMemoryEntities() {
        ArrayList<Memory> list = new ArrayList<Memory>();
        for (MemoryDTO dto: memories) {
            list.add(dto.toMemory());
        }
        return list;
    }
}
