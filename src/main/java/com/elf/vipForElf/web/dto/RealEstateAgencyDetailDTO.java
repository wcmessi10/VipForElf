package com.elf.vipForElf.web.dto;

import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgency;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@NoArgsConstructor
@Getter
public class RealEstateAgencyDetailDTO {
    String realEstateAgencyName;
    OffsetDateTime registDt;
    String contact;
    String description;

    public RealEstateAgencyDetailDTO(RealEstateAgency realEstateAgency){
        this.realEstateAgencyName = realEstateAgency.getRealEstateAgencyName();
        this.registDt = realEstateAgency.getRegistDt();
        this.contact = realEstateAgency.getContact();
        this.description = realEstateAgency.getDescription();
    }
}
