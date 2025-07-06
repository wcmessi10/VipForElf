package com.elf.vipForElf.domain.realEstateAgency.vo;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import lombok.Data;

@Data
public class RealEstateAgencyRow {
    Long id;
    String realEstateAgencyName;

    public RealEstateAgencyRow(RealEstateAgencyEntity realEstateAgencyEntity){
        this.id = realEstateAgencyEntity.getId();
        this.realEstateAgencyName = realEstateAgencyEntity.getRealEstateAgencyName();
    }
}
