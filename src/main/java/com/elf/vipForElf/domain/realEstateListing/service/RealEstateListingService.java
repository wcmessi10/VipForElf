package com.elf.vipForElf.domain.realEstateListing.service;

import com.elf.vipForElf.web.dto.NewRealEstateListingDTO;
import com.elf.vipForElf.web.dto.RegistedRealEstateListingDTO;

public interface RealEstateListingService {
    RegistedRealEstateListingDTO registRealEstateListing(NewRealEstateListingDTO newRealEstateListingDTO) throws IllegalAccessException;
}
