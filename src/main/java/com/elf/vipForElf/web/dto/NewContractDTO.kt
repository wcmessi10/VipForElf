package com.elf.vipForElf.web.dto

import java.time.OffsetDateTime

data class NewContractDTO(
    val realEstateListingId: Long?,
    val realEstateAgencyId: Long?,
    val landLordId: String?,
    val moveInDt: OffsetDateTime?
)
