package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.realEstateAgency.service.RealEstateAgencyService;
import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgencyRow;
import com.elf.vipForElf.domain.realEstateAgency.vo.RegistedEstateAgencyVO;
import com.elf.vipForElf.web.dto.NewRealEstateAgencyDTO;
import com.elf.vipForElf.web.dto.RealEstateAgencyDetailDTO;
import com.elf.vipForElf.web.dto.RealEstateAgencyListDTO;
import com.elf.vipForElf.web.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getRealEstateAgencyList")
    public ResponseDTO<RealEstateAgencyListDTO> getRealEstateAgencyList(@RequestParam Integer page,
                                                                        @RequestParam Integer size,
                                                                        @RequestParam(defaultValue = "registDt") String sort,
                                                                        @RequestParam String searchCondition){
        Pageable pageable = PageRequest.of(page,size, Sort.by(sort).descending());
        List<RealEstateAgencyRow> realEstateAgencyRowList = realEstateAgencyService.getRealEstateAgencyList(searchCondition,pageable);
        Long totalCount = realEstateAgencyService.getTotalCount();
        return new ResponseDTO<>(new RealEstateAgencyListDTO(totalCount,realEstateAgencyRowList));
    }

    @GetMapping("/getRealEstateAgencyDetail/{id}")
    public ResponseDTO<RealEstateAgencyDetailDTO> getRealEstateAgencyDetail(@PathVariable("id") Long id){
        RealEstateAgencyDetailDTO realEstateAgencyDetailDTO = new RealEstateAgencyDetailDTO(realEstateAgencyService.getRealEstateAgencyDetail(id));
        return new ResponseDTO<>(realEstateAgencyDetailDTO);
    }
}
