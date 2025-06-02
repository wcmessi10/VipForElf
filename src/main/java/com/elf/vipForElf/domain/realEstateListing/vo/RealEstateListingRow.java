package com.elf.vipForElf.domain.realEstateListing.vo;

import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RealEstateListingRow {
    Long id;
    String listingType;
    String listingName;
    RealEstateListingEntity.OccupancyType occupancyType;

    public RealEstateListingRow(RealEstateListingEntity realEstateListingEntity){
        this.id = realEstateListingEntity.getId();
        this.listingType = realEstateListingEntity.getListingType();
        this.listingName = realEstateListingEntity.getListingName();
        this.occupancyType = realEstateListingEntity.getOccupancyType();
    }
}
