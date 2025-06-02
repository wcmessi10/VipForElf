package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.realEstateListing.service.RealEstateListingService;
import com.elf.vipForElf.web.dto.NewRealEstateListingDTO;
import com.elf.vipForElf.web.dto.RegistedRealEstateListingDTO;
import com.elf.vipForElf.web.dto.ResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/realEstateListing")
public class RealEstateListingController {
    private final RealEstateListingService realEstateListingService;

    public RealEstateListingController(RealEstateListingService realEstateListingService) {
        this.realEstateListingService = realEstateListingService;
    }

    @PostMapping("/registRealEstateListing")
    public ResponseDTO<RegistedRealEstateListingDTO> registRealEstateListing(@RequestBody NewRealEstateListingDTO newRealEstateListingDTO) throws IllegalAccessException {
        return new ResponseDTO<>(realEstateListingService.registRealEstateListing(newRealEstateListingDTO));
    }
}
