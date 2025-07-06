package com.elf.vipForElf.domain.realEstateAgency.vo

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity
import java.time.OffsetDateTime

data class RealEstateAgency(
    val id: Long?,
    val realEstateAgencyName: String?,
    val registDt: OffsetDateTime?,
    val description: String?,
    val contact: String?
) {
    constructor(realEstateAgencyEntity: RealEstateAgencyEntity) : this(
        id = realEstateAgencyEntity.id,
        realEstateAgencyName = realEstateAgencyEntity.realEstateAgencyName,
        registDt = realEstateAgencyEntity.registDt,
        description = realEstateAgencyEntity.description,
        contact = realEstateAgencyEntity.contact
    )
}
