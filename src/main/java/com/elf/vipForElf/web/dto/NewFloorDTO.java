package com.elf.vipForElf.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NewFloorDTO {
    Integer floorNumber;
    String purpose;
    Long buildingId;
}
