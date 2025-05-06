package com.elf.vipForElf.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewFloorDTO {
    Integer floorNumber;
    String purpose;
    Long buildingId;
}
