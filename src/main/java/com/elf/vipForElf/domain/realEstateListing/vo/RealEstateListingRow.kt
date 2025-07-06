package com.elf.vipForElf.domain.realEstateListing.vo

import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity

data class RealEstateListingRow(
    var id: Long? = null,
    var listingType: String? = null,
    var listingName: String? = null,
    var occupancyType: RealEstateListingEntity.OccupancyType? = null
) {
    constructor(realEstateListingEntity: RealEstateListingEntity) : this(
        id = realEstateListingEntity.id,
        listingType = realEstateListingEntity.listingType,
        listingName = realEstateListingEntity.listingName,
        occupancyType = realEstateListingEntity.occupancyType
    )
}
