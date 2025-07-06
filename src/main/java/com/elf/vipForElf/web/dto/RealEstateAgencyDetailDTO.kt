package com.elf.vipForElf.web.dto

import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgency
import java.time.OffsetDateTime

data class RealEstateAgencyDetailDTO(
    val realEstateAgencyName: String?,
    val registDt: OffsetDateTime?,
    val contact: String?,
    val description: String?
) {
    constructor(realEstateAgency: RealEstateAgency) : this(
        realEstateAgencyName = realEstateAgency.realEstateAgencyName,
        registDt = realEstateAgency.registDt,
        contact = realEstateAgency.contact,
        description = realEstateAgency.description
    )
}
