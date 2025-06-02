package com.elf.vipForElf.web.dto;

import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class RegistedRealEstateListingDTO {
    Long id;
    String listingType;
    Long listingId;
    RealEstateListingEntity.OccupancyType occupancyType;
    BigDecimal salePrice;
    BigDecimal deposit;
    BigDecimal monthlyRent;
    String status;

    public RegistedRealEstateListingDTO(RealEstateListingEntity realEstateListingEntity){
        this.id = realEstateListingEntity.getId();
        this.listingId = realEstateListingEntity.getListingId();
        this.listingType = realEstateListingEntity.getListingType();
        this.occupancyType = realEstateListingEntity.getOccupancyType();
        this.salePrice = realEstateListingEntity.getSalePrice();
        this.deposit = realEstateListingEntity.getDeposit();
        this.monthlyRent = realEstateListingEntity.getMonthlyRent();
        this.status = realEstateListingEntity.getStatus();
    }
}
