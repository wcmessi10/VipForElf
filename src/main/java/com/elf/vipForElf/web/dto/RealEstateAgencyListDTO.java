package com.elf.vipForElf.web.dto;

import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgencyRow;
import lombok.Data;

import java.util.List;

@Data
public class RealEstateAgencyListDTO {
    Long totalCount;
    List<RealEstateAgencyRow> realEstateAgencyRowList;

    public RealEstateAgencyListDTO(Long totalCount, List<RealEstateAgencyRow> realEstateAgencyRowList){
        this.totalCount = totalCount;
        this.realEstateAgencyRowList = realEstateAgencyRowList;
    }
}
