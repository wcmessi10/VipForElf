package com.elf.vipForElf.web.dto

import com.elf.vipForElf.domain.realEstateListing.vo.RealEstateListingRow

data class RealEstateListingListDTO(
    var totalCount: Long? = null,
    var realEstateListingRowList: List<RealEstateListingRow>? = null
)
