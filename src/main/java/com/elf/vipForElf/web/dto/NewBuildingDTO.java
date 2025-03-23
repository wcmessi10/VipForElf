package com.elf.vipForElf.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NewBuildingDTO {
    private String buildingName;
    private String address;
    private String buildingNumber;
    private String businessNumber;
    private String zipcode;
}
