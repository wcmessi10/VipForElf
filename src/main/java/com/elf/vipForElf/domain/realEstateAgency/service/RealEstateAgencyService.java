package com.elf.vipForElf.domain.realEstateAgency.service;

import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgency;
import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgencyRow;
import com.elf.vipForElf.domain.realEstateAgency.vo.RegistedEstateAgencyVO;
import com.elf.vipForElf.web.dto.NewRealEstateAgencyDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RealEstateAgencyService {
    RegistedEstateAgencyVO registerNew(NewRealEstateAgencyDTO newRealEstateAgencyDTO);
    List<RealEstateAgencyRow> getRealEstateAgencyList(String searchCondition, Pageable pageable);
    Long getTotalCount();
    RealEstateAgency getRealEstateAgencyDetail(Long id);
}
