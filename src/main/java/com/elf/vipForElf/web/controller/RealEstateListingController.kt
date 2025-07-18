package com.elf.vipForElf.web.controller

import com.elf.vipForElf.domain.realEstateListing.service.RealEstateListingService
import com.elf.vipForElf.web.dto.NewRealEstateListingDTO
import com.elf.vipForElf.web.dto.RealEstateListingListDTO
import com.elf.vipForElf.web.dto.RegistedRealEstateListingDTO
import com.elf.vipForElf.web.dto.ResponseDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/realEstateListing")
class RealEstateListingController(
    private val realEstateListingService: RealEstateListingService
) {

    @PostMapping("/registRealEstateListing")
    fun registRealEstateListing(
        @RequestBody newRealEstateListingDTO: NewRealEstateListingDTO
    ): ResponseDTO<RegistedRealEstateListingDTO> {
        return ResponseDTO(
            realEstateListingService.registRealEstateListing(newRealEstateListingDTO)
        )
    }

    @GetMapping("/getRealEstateListingList")
    fun getRealEstateListingList(
        @RequestParam(defaultValue = "page") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
        @RequestParam searchCondition: String
    ): ResponseDTO<RealEstateListingListDTO> {
        return ResponseDTO(
            realEstateListingService.getRealEstateListingList(
                page,
                size,
                searchCondition
            )
        )
    }

    @GetMapping("/getRealEstateListingDetail/{id}")
    fun getRealEstateListingDetail(
        @PathVariable id: Long
    ): ResponseDTO<Any> {
        return ResponseDTO(
            realEstateListingService.getRealEstateListingDetail(id)
        )
    }
}
