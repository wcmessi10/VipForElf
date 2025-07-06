package com.elf.vipForElf.web.dto

import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgencyRow

data class RealEstateAgencyListDTO(
    val totalCount: Long?,
    val realEstateAgencyRowList: List<RealEstateAgencyRow>?
)
