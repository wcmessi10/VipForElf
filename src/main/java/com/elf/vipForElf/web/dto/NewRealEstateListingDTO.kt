package com.elf.vipForElf.web.dto

import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity
import java.math.BigDecimal

data class NewRealEstateListingDTO(
    var listingType: String? = null,
    var listingId: Long? = null,
    var listingName: String? = null,
    var occupancyType: RealEstateListingEntity.OccupancyType? = null,
    var salePrice: BigDecimal? = null,
    var deposit: BigDecimal? = null,
    var monthlyRent: BigDecimal? = null,
    var status: String? = null,
    var realEstateAgencyId: Long? = null
)
