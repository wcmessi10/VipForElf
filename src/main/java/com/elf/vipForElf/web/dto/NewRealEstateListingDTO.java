package com.elf.vipForElf.web.dto;

import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Setter
public class NewRealEstateListingDTO {
    String listingType;
    Long listingId;
    String listingName;
    RealEstateListingEntity.OccupancyType occupancyType;
    BigDecimal salePrice;
    BigDecimal deposit;
    BigDecimal monthlyRent;
    String status;
    Long realEstateAgencyId;

}
