package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.realEstateListing.service.RealEstateListingService;
import com.elf.vipForElf.domain.realEstateListing.vo.RealEstateListingListDTO;
import com.elf.vipForElf.web.dto.NewRealEstateListingDTO;
import com.elf.vipForElf.web.dto.RegistedRealEstateListingDTO;
import com.elf.vipForElf.web.dto.ResponseDTO;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getRealEstateListingList")
    public ResponseDTO<RealEstateListingListDTO> getRealEstateListingList(@RequestParam(defaultValue = "page") Integer page,
                                                                          @RequestParam(defaultValue = "10") Integer size,
                                                                          @RequestParam String searchCondition){
        return new ResponseDTO<>(realEstateListingService.getRealEstateListingList(page,size,searchCondition));
    }

    @GetMapping("/getRealEstateListingDetail/{id}")
    public ResponseDTO<?> getRealEstateListingDetail(@PathVariable Long id){
        return new ResponseDTO<>(realEstateListingService.getRealEstateListingDetail(id));
    }
}
