package com.elf.vipForElf.domain.realEstateAgency.vo

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity

data class RealEstateAgencyRow(
    val id: Long,
    val realEstateAgencyName: String
) {
    constructor(realEstateAgencyEntity: RealEstateAgencyEntity) : this(
        id = realEstateAgencyEntity.id,
        realEstateAgencyName = realEstateAgencyEntity.realEstateAgencyName
    )
}
