package com.elf.vipForElf.domain.realEstateAgency.vo;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class RealEstateAgency {
    Long id;
    String realEstateAgencyName;
    OffsetDateTime registDt;
    String description;
    String contact;

    public RealEstateAgency(RealEstateAgencyEntity realEstateAgencyEntity){
        this.id = realEstateAgencyEntity.getId();
        this.realEstateAgencyName = realEstateAgencyEntity.getRealEstateAgencyName();
        this.registDt = realEstateAgencyEntity.getRegistDt();
        this.description = realEstateAgencyEntity.getDescription();
        this.contact = realEstateAgencyEntity.getContact();
    }
}
