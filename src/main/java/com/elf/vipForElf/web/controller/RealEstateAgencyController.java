package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.realEstateAgency.service.RealEstateAgencyService;
import com.elf.vipForElf.domain.realEstateAgency.vo.RegistedEstateAgencyVO;
import com.elf.vipForElf.web.dto.NewRealEstateAgencyDTO;
import com.elf.vipForElf.web.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/realEstateAgency")
public class RealEstateAgencyController {

    private final RealEstateAgencyService realEstateAgencyService;

    public RealEstateAgencyController(RealEstateAgencyService realEstateAgencyService) {
        this.realEstateAgencyService = realEstateAgencyService;
    }

    @PostMapping("/registerNew")
    public ResponseDTO<RegistedEstateAgencyVO> registerNew(@RequestBody NewRealEstateAgencyDTO newRealEstateAgencyDTO){
        return new ResponseDTO<>(realEstateAgencyService.registerNew(newRealEstateAgencyDTO));
    }
}
