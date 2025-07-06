package com.elf.vipForElf.web.dto

import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity
import java.math.BigDecimal

data class RegistedRealEstateListingDTO(
    val id: Long?,
    val listingType: String?,
    val listingId: Long?,
    val listingName: String?,
    val occupancyType: RealEstateListingEntity.OccupancyType?,
    val salePrice: BigDecimal?,
    val deposit: BigDecimal?,
    val monthlyRent: BigDecimal?,
    val status: String?
) {
    constructor(realEstateListingEntity: RealEstateListingEntity) : this(
        id = realEstateListingEntity.id,
        listingId = realEstateListingEntity.listingId,
        listingType = realEstateListingEntity.listingType,
        listingName = realEstateListingEntity.listingName,
        occupancyType = realEstateListingEntity.occupancyType,
        salePrice = realEstateListingEntity.salePrice,
        deposit = realEstateListingEntity.deposit,
        monthlyRent = realEstateListingEntity.monthlyRent,
        status = realEstateListingEntity.status
    )
}
