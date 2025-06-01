package com.elf.vipForElf.domain.realEstateAgency.vo;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;

import java.time.OffsetDateTime;

public class RegistedEstateAgencyVO {
    String realEstateAgencyName;
    OffsetDateTime registDt;
    String contact;
    String description;

    public RegistedEstateAgencyVO(RealEstateAgencyEntity save) {
        this.realEstateAgencyName=save.getRealEstateAgencyName();
        this.registDt =save.getRegistDt();
        this.contact = save.getContact();
        this.description = save.getDescription();
    }
}
