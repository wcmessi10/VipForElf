package com.elf.vipForElf.domain.realEstateAgency.service;

import com.elf.vipForElf.domain.realEstateAgency.vo.RegistedEstateAgencyVO;
import com.elf.vipForElf.web.dto.NewRealEstateAgencyDTO;

public interface RealEstateAgencyService {
    RegistedEstateAgencyVO registerNew(NewRealEstateAgencyDTO newRealEstateAgencyDTO);
}
