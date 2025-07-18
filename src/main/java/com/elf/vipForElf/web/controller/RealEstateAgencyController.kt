package com.elf.vipForElf.web.controller

import com.elf.vipForElf.domain.realEstateAgency.service.RealEstateAgencyService
import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgencyRow
import com.elf.vipForElf.domain.realEstateAgency.vo.RegistedEstateAgencyVO
import com.elf.vipForElf.web.dto.NewRealEstateAgencyDTO
import com.elf.vipForElf.web.dto.RealEstateAgencyDetailDTO
import com.elf.vipForElf.web.dto.RealEstateAgencyListDTO
import com.elf.vipForElf.web.dto.ResponseDTO
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/realEstateAgency")
class RealEstateAgencyController(
    private val realEstateAgencyService: RealEstateAgencyService
) {

    @PostMapping("/registerNew")
    fun registerNew(
        @RequestBody newRealEstateAgencyDTO: NewRealEstateAgencyDTO
    ): ResponseDTO<RegistedEstateAgencyVO> {
        return ResponseDTO(
            realEstateAgencyService.registerNew(newRealEstateAgencyDTO)
        )
    }

    @GetMapping("/getRealEstateAgencyList")
    fun getRealEstateAgencyList(
        @RequestParam page: Int,
        @RequestParam size: Int,
        @RequestParam(defaultValue = "registDt") sort: String,
        @RequestParam searchCondition: String
    ): ResponseDTO<RealEstateAgencyListDTO> {
        val pageable: Pageable = PageRequest.of(
            page,
            size,
            Sort.by(sort).descending()
        )

        val realEstateAgencyRowList: List<RealEstateAgencyRow> =
            realEstateAgencyService.getRealEstateAgencyList(searchCondition, pageable)

        val totalCount: Long = realEstateAgencyService.getTotalCount()

        return ResponseDTO(
            RealEstateAgencyListDTO(
                totalCount,
                realEstateAgencyRowList
            )
        )
    }

    @GetMapping("/getRealEstateAgencyDetail/{id}")
    fun getRealEstateAgencyDetail(
        @PathVariable("id") id: Long
    ): ResponseDTO<RealEstateAgencyDetailDTO> {
        val realEstateAgencyDetailDTO = RealEstateAgencyDetailDTO(
            realEstateAgencyService.getRealEstateAgencyDetail(id)
        )
        return ResponseDTO(realEstateAgencyDetailDTO)
    }
}
