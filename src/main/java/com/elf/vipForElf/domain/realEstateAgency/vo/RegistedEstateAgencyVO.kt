package com.elf.vipForElf.domain.realEstateAgency.vo

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity
import java.time.OffsetDateTime

data class RegistedEstateAgencyVO(
    val id: Long,
    val realEstateAgencyName: String,
    val registDt: OffsetDateTime?,
    val contact: String,
    val description: String?
) {
    constructor(save: RealEstateAgencyEntity) : this(
        id = save.id,
        realEstateAgencyName = save.realEstateAgencyName,
        registDt = save.registDt,
        contact = save.contact,
        description = save.description
    )
}
