package com.elf.vipForElf.domain.contract.vo

import com.elf.vipForElf.web.dto.NewContractDTO
import java.time.OffsetDateTime

data class NewContract(
    val realEstateListingId: Long?,
    val realEstateAgencyId: Long?,
    val landLordId: String?,
    val moveInDt: OffsetDateTime?
) {
    constructor(newContractDTO: NewContractDTO) : this(
        realEstateListingId = newContractDTO.realEstateListingId,
        realEstateAgencyId = newContractDTO.realEstateAgencyId,
        landLordId = newContractDTO.landLordId,
        moveInDt = newContractDTO.moveInDt
    )
}
