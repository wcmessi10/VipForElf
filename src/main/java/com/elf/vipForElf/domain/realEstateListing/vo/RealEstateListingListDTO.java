package com.elf.vipForElf.domain.realEstateListing.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RealEstateListingListDTO {
    Long totalCount;
    List<RealEstateListingRow> realEstateListingRowList;

    public RealEstateListingListDTO(Long totalCount, List<RealEstateListingRow> realEstateListingRowList) {
        this.realEstateListingRowList = realEstateListingRowList;
        this.totalCount = totalCount;
    }
}
