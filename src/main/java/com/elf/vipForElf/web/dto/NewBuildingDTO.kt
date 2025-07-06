package com.elf.vipForElf.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewBuildingDTO {
    private String buildingName;
    private String address;
    private String buildingNumber;
    private String businessNumber;
    private String zipcode;
}
